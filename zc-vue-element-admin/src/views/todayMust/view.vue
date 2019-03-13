<template>
    <div style="width:95%;margin: 5px auto;">
        <el-card class="box-card" style="width: 100%;">
            <div slot="header" class="clearfix" style="text-align: center;">
                <span style="font-size: 2em;margin: 0.67em 0;font-weight: bold;">今日必达</span>
            </div>
            <div class="app-container">
              <div class="filter-container">
                <el-input :placeholder="$t('table.title')" v-model="listQuery.title" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter"/>
                <el-select :placeholder="$t('table.state')" v-model="listQuery.complete" style="width: 140px" class="filter-item" @change="handleFilter">
                    <el-option v-for="item in completeList" :key="item.key" :label="item.label" :value="item.key"/>
                </el-select>
                <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">{{ $t('table.search') }}</el-button>
                <!-- 判断当前选中的是几条数据   如果是多条则是批量修改  如果是单条则是修改  如果是无则是添加 -->
                <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">{{ $t('table.add') }}</el-button>
                <el-button type="primary" class="filter-item" icon="el-icon-delete" @click="batchDelete">{{ $t('table.delete') }}</el-button>
                <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">{{ $t('table.export') }}</el-button>
              </div>
              <el-table ref="todayMustList" :data='todayMustList' tooltip-effect="dark" style="width: 100%;" @selection-change="handleSelectionChange" max-height="600">
                <el-table-column type="selection" width="50%" align="center" fixed></el-table-column>
                <el-table-column label="序号" type="index" width="50%" align="center" fixed></el-table-column>
                <el-table-column label="创建日期" width="150%" align="center" fixed>
                  <template slot-scope="scope">{{ scope.row.createDate.substring(0,10) }}</template>
                </el-table-column>
                <el-table-column label="执行时间" width="150%" align="center" fixed>
                  <template slot-scope="scope">
                      <!-- 此处的表尽可能的根据时间的越来越近，并且任务待办的情况下，用颜色来表示轻重缓急 -->
                      <i class="el-icon-time"></i>
                      {{ scope.row.executionTime.substring(11) }}</template>
                </el-table-column>
                <el-table-column prop="title" label="必达主题" width="900%" align="center" show-overflow-tooltip>
                  <!--  如果是单条则是修改  -->
                  <template slot-scope="scope">
                    <el-popover trigger="click" placement="top">
                      <p class="bold">必达主题</p>
                      <p>{{ scope.row.title }}</p>
                      <p class="bold">必达信息</p>
                      <p>{{ scope.row.todaymust }}</p>
                      <div slot="reference" class="name-wrapper">
                          <el-tag size="medium">{{ scope.row.title }}</el-tag>
                      </div>
                    </el-popover>
                  </template>
                </el-table-column>
                <el-table-column label="状态" width="100%" align="center">
                  <template slot-scope="scope">
                    <!-- 此处尽可能改成标签 -->
                    <el-tag type="danger" v-if="scope.row.complete == false">未完成</el-tag>
                    <el-tag type="success" v-if="scope.row.complete == true">已完成</el-tag>
                  </template>
                </el-table-column>
                <el-table-column label="操作" width="100%" align="center" fixed="right">
                  <template slot-scope="scope">
                    <el-button type="primary" size="mini" icon='el-icon-edit'></el-button>
                    <!--<el-button type="danger" size="mini" icon='el-icon-delete'></el-button>-->
                  </template>
                </el-table-column>
              </el-table>
              <!-- 分页 -->
              <el-pagination
                background
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                layout="total, sizes, prev, pager, next, jumper"
                :page-sizes="[10, 20, 50]"
                :page-size="listQuery.limit"
                :current-page="listQuery.page"
                :total="total">
              </el-pagination>
            </div>
        </el-card>
    </div>
</template>

<script>

    import { mapGetters } from 'vuex'
    import { getTodayMustList, batchDeleteTodayMust } from '@/api/todayMust' // 请求

    export default {
        data(){
            return {
              // 查询条件
              listQuery: {
                  user: 0,
                  page: 1, // 第几页
                  limit: 10, // 单页多少条
                  today: true,// 是否是当天
                  title: '', //主题
                  complete: false // 完成状态
              },
              total: 0,
              // 状态选框
              completeList: [{label:'未完成',key:false},{label:'已完成',key:true}],
              // 今日必达事项
              todayMustList: [
                {id:'1',user:'1',createDate:'21:04:00',executionTime:'22:00:00',title: '示例主题',todaymust:'示例信息',complete:true,sort:1}
                ],
              // 当前选中的数据
              multipleSelection: {},
              // 是否正在下载文件
              downloadLoading: false
            }
        },
        computed: {
            ...mapGetters([
                'user'
            ])
        },
        created () {
            this.getList();
        },
        methods: {
          handleFilter() {
            /**
             * 查询数据响应方法
             */
            this.listQuery.page = 1
            this.getList()
          },
          getList(){
            /**
             * 获取今日必达事项
             */
            this.listQuery.user = this.user
              getTodayMustList(this.listQuery).then(response => {
                const data = response.data
                this.todayMustList = data.todayMusts
                this.total = data.total
              })
          },
          batchDelete() {
            /**
             * 批量删除今日必达
             */
            deleteTodaysMust(this.multipleSelection).then(response => {
                console.log('删除完毕');
            })
          },
          handleSelectionChange(val) {
            /**
             * val中存储的数据是当前选中的所有数据类型为数组
             * 将所有选中的数据赋值到变量multipleSelection中
             */
            this.multipleSelection = val;
          },
          handleCreate() {
            /**
             * 添加页面
             */
          },
          handleDownload() {
            /**
             * 导出数据
             */
          },
          handleSizeChange(val) {
            /**
             * pageSize 改变时会触发
             */
            this.listQuery.limit = val
            this.getList()
          },
          handleCurrentChange(val) {
            /**
             * currentPage 改变时会触发
             */
            this.listQuery.page = val
            this.getList()
          }
        }
    }
</script>

<style>
    .text {
      font-size: 14px;
    }

    .item {
      margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
      display: table;
      content: "";
    }
    .clearfix:after {
      clear: both
    }

    .box-card {
      width: 480px;
    }

    .bold {
        font-weight: bold;
    }
  </style>
