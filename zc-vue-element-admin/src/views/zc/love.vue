<template>
    <el-container>
        <!--<el-header>Header</el-header>-->
        <el-container>
            <el-main width="50%">
                 <div class="left-container"  style="margin:auto 20%;padding-bottom: 20px;">
                    <el-card class="box-card-component" style="margin-left:8px;">
                            <div slot="header" class="box-card-header">
                              <img src="https://wpimg.wallstcn.com/e7d23d71-cf19-4b90-a1cc-f56af8c0903d.png">
                            </div>
                            <div style="position:relative;">
                              <pan-thumb :image="nanZJ.avatar" class="panThumb"/>
                              <mallki class-name="mallki-text" :text="nanZJ.name"/>
                              <div style="padding-top:35px;" class="progress-item">
                                    <el-tag>属性分评</el-tag>
                              </div>
                              <el-collapse accordion :loading="loading.nan">
                                <div v-for="NanProgress in NanProgressList" class="progress-item">
                                  <el-collapse-item>
                                    <template slot="title">
                                      <span slot="reference">{{ NanProgress.attrname }}</span>
                                      <i class="header-icon el-icon-info"></i>
                                      <div style="display: inline;">
                                          <el-progress :percentage="NanProgress.progress" :status="NanProgress.status"
                                          style="float: right;width: 70%;top:35%;"/>
                                      </div>
                                    </template>
                                    <el-card shadow="hover" class="box-card">
                                        <div slot="header" class="clearfix">
                                          <span class="features" style="height: 46px;line-height: 46px;">评价：</span>

                                          <el-dropdown style="float: right;" class="features" v-if="user == nvZJ.user">
                                              <span class="el-dropdown-link">
                                                  <el-button type="primary" size="mini" circle icon="el-icon-more"></el-button>
                                              </span>
                                              <el-dropdown-menu slot="dropdown">
                                                  <router-link :to="'/zc/edit/'+NanProgress.id+'/'+nanZJ.user">
                                                    <el-dropdown-item>
                                                        <el-button class="dorpdownItem" circle size="mini" icon="el-icon-edit"></el-button>
                                                    </el-dropdown-item>
                                                  </router-link>
                                                  <router-link :to="'/zc/edit/add/'+nanZJ.user">
                                                    <el-dropdown-item>
                                                        <el-button class="dorpdownItem" circle size="mini" icon="el-icon-plus"></el-button>
                                                    </el-dropdown-item>
                                                  </router-link>
                                                  <el-dropdown-item>
                                                      <el-button class="dorpdownItem" circle size="mini" icon="el-icon-delete" @click="deleteAttr(NanProgress.id)"></el-button>
                                                  </el-dropdown-item>
                                              </el-dropdown-menu>
                                            </el-dropdown>
                                        </div>
                                        <span class="">&emsp;&emsp;{{ NanProgress.features }}</span>
                                    </el-card>
                                  </el-collapse-item>
                                </div>
                              </el-collapse>
                            </div>
                          </el-card>
                          </div>
            </el-main>
            <el-main>
                    <div class="right-container"  style="margin-left: 10%;padding-bottom: 20px;">
                            <el-card class="box-card-component" style="margin-left:8px;">
                              <div slot="header" class="box-card-header">
                                <img src="https://wpimg.wallstcn.com/e7d23d71-cf19-4b90-a1cc-f56af8c0903d.png">
                              </div>
                              <div style="position:relative;">
                                <pan-thumb :image="nvZJ.avatar" class="panThumb"/>
                                <mallki class-name="mallki-text" :text="nvZJ.name"/>
                                <div style="padding-top:35px;" class="progress-item">
                                  <el-tag>属性分评</el-tag>
                                </div>
                                <el-collapse accordion :loading="loading.nv">
                                  <div v-for="NvProgress in NvProgressList" class="progress-item">
                                    <el-collapse-item>
                                      <template slot="title">
                                        <span slot="reference">{{ NvProgress.attrname }}</span>
                                        <i class="header-icon el-icon-info"></i>
                                        <div style="display: inline;">
                                            <el-progress :percentage="NvProgress.progress" :status="NvProgress.status"
                                            style="float: right;width: 70%;top:35%;"/>
                                        </div>
                                      </template>
                                      <el-card shadow="hover" class="box-card">
                                          <div slot="header" class="clearfix">
                                            <span class="features" style="height: 46px;line-height: 46px;">评价：</span>

                                            <el-dropdown style="float: right;" class="features" v-if="user == nanZJ.user">
                                              <span class="el-dropdown-link">
                                                  <el-button type="primary" size="mini" circle icon="el-icon-more"></el-button>
                                              </span>
                                              <el-dropdown-menu slot="dropdown">
                                                  <router-link :to="'/zc/edit/'+NvProgress.id+'/'+nvZJ.user">
                                                    <el-dropdown-item>
                                                        <el-button class="dorpdownItem" circle size="mini" icon="el-icon-edit"></el-button>
                                                    </el-dropdown-item>
                                                  </router-link>
                                                  <router-link :to="'/zc/edit/add/'+nvZJ.user">
                                                    <el-dropdown-item>
                                                        <el-button class="dorpdownItem" circle size="mini" icon="el-icon-plus"></el-button>
                                                    </el-dropdown-item>
                                                  </router-link>
                                                  <el-dropdown-item>
                                                      <el-button class="dorpdownItem" circle size="mini" icon="el-icon-delete" @click="deleteAttr(NvProgress.id)"></el-button>
                                                  </el-dropdown-item>
                                              </el-dropdown-menu>
                                            </el-dropdown>
                                          </div>
                                          <span class="">&emsp;&emsp;{{ NvProgress.features }}</span>
                                      </el-card>
                                    </el-collapse-item>
                                  </div>
                                </el-collapse>
                              </div>
                            </el-card>
                          </div>
            </el-main>
        </el-container>
        <!--<el-footer>Footer</el-footer>-->
    </el-container>
</template>

<style scoped>
    .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
  }

  body > .el-container {
    margin-bottom: 40px;
  }
</style>

<script>
  import { mapGetters } from 'vuex'
  import PanThumb from '@/components/PanThumb'
  import Mallki from '@/components/TextHoverEffect/Mallki'
  import splitPane from 'vue-splitpane'
  import { getAttributeList, getCabinCrew, attrDelete } from '@/api/zc'

  export default {
    name: 'SplitpaneDemo',
    components: { splitPane,PanThumb, Mallki },
    methods: {
      resize() {
        console.log('resize')
      },
      deleteAttr(attrid) {
        var data = {id: attrid}
        attrDelete(data).then(response => {
          if(response.data.success){
            // 还没有实现删除后刷新属性列表
            if(user == nvZJ.user){
              //说明只能编辑男生
              getNanProgressList()
            }else{
              //说明只能编辑女生
              getNvProgressList()
            }
          }
        })
      },
      getNanzjAnNvzj() {
        const query = {
          'hut': this.$route.path.substring(this.$route.path.lastIndexOf('/')+1),
          'key': 123
        }
        getCabinCrew(query).then(response => {
          this.nanZJ = response.data.nanzj
          this.nvZJ = response.data.nvzj
        })
      },
      getNanProgressList() {
        this.loading.nan = true
        var query = {'user': this.nanZJ.user}
        getAttributeList(query).then(response => {
          this.NanProgressList = response.data.attrList
          this.loading.nan = false
        })
      },
      getNvProgressList() {
        this.loading.nv = true
        var query = {'user': this.nvZJ.user}
        getAttributeList(query).then(response => {
          this.NvProgressList = response.data.attrList
          this.loading.nv = false
        })
      }
    },
    created () {
      //根据房间id获取男女主角
      this.getNanzjAnNvzj()
      // 获取男女主角的属性信息
      this.getNanProgressList()
      this.getNvProgressList()
    },
    data() {
      return {
        statisticsData: {
          article_count: 1024,
          pageviews_count: 1024
        },
        loading: {
          nan: false,
          nv: false
        },
        nanZJ: {user: 1,name: '男主角',avatar: ''},
        nvZJ: {user: 2,name: '女主角',avatar: ''},
        NanProgressList:[{id:0,user_id:0,attrname:'无',progress: 0,status:'',features:''}],
        NvProgressList:[{id:0,user_id:0,attrname:'无',progress: 0,status:'',features:''}]
      }
    },
    computed: {
      ...mapGetters([
        'user'
      ])
    }
  }
</script>

<style  scoped>
  .components-container {
    position: relative;
    height: 128vh;
  }

  .left-container {
    /*background-color: #F38181;*/
    height: auto;
    width: 400px;
  }

  .right-container {
    /*background-color: #FCE38A;*/
    height: 100%;
    width: 400px;
  }

  .top-container {
    background-color: #FCE38A;
    width: 100%;
    height: 100%;
  }

  .bottom-container {
    width: 100%;
    background-color: #95E1D3;
    height: 100%;
  }

  .features {
    margin: 10px;
  }

  .dorpdownItem {
    margin: 5px auto;
  }
</style>

<style>
/*为了保证头像在白色半圆内*/
.pan-thumb{
      left: 0px;
  }
</style>

<style rel="stylesheet/scss" lang="scss" >
.box-card-component{
  .el-card__header {
    padding: 0px!important;
  }
}
</style>
<style rel="stylesheet/scss" lang="scss" scoped>
  .box-card-component {
    .box-card-header {
      position: relative;
      height: 220px;
      img {
        width: 100%;
        height: 100%;
        transition: all 0.2s linear;
        &:hover {
          transform: scale(1.1, 1.1);
          filter: contrast(130%);
        }
      }
    }
    .mallki-text {
      position: absolute;
      top: 0px;
      right: 0px;
      font-size: 20px;
      font-weight: bold;
    }
    .panThumb {
      z-index: 100;
      height: 70px!important;
      width: 70px!important;
      position: absolute!important;
      top: -45px;
      left: 0px;
      border: 5px solid #ffffff;
      background-color: #fff;
      margin: auto;
      box-shadow: none!important;
      /deep/ .pan-info {
        box-shadow: none!important;
      }
    }
    .progress-item {
      margin-bottom: 10px;
      font-size: 14px;
    }
    @media only screen and (max-width: 1510px){
      .mallki-text{
        /*display: none;*/
      }
    }
  }
</style>
