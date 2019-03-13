<template>
  <div style="width:50%;margin: 20px auto;">
    <el-card v-loading="cardLoading">
      <el-form label-position="top" label-width="80px" :model="formLabelAlign">
        <el-form-item>
          <label slot="label">{{ $t('zc.attrname') }}</label>
          <el-input v-model="formLabelAlign.attrname"></el-input>
        </el-form-item>
        <el-form-item>
            <label slot="label">{{ $t('zc.features') }}</label>
          <el-input type="textarea" autosize v-model="formLabelAlign.features" ></el-input>
        </el-form-item>
        <el-form-item>
          <label slot="label">{{ $t('zc.progress') }}</label>
          <el-slider v-model="formLabelAlign.progress" show-input></el-slider>
        </el-form-item>
        <el-row type="flex" justify="space-around">
          <el-col :span="4">
              <el-button v-loading="commitLoading" type="primary" @click="update">{{ $t('zc.commit') }}</el-button>
          </el-col>
        </el-row>
      </el-form>
    </el-card>
  </div>
</template>

  <script>
  import { getAttribute, updateAttribute } from '@/api/zc'

    export default {
      data() {
        // 获取路由的路径打印一下就知道了this.$route
        // console.log(this.$route)
        var id = 0
        var user = 0
        id = parseInt(this.$route.params.annalid)
        user = parseInt(this.$route.params.zjid)
        return {
          formLabelAlign: {
            id: id,
            user: user,
            attrname: '',
            features: '',
            progress: 0,
            index: 0,
            add_time: '',
            status: 0
          },
          cardLoading: false,
          commitLoading: false
        };
      },
      created() {
        this.loadServerData();
      },
      methods: {
        loadServerData(){
          // 如果id存在再获取对应的值
          if(this.formLabelAlign.id){
            this.cardLoading = true
            var timer=new Date().getTime().toString();
            var query =  {'id': this.formLabelAlign.id, 't': timer};
            // 获取后台数据
            getAttribute(query).then(response => {
              this.formLabelAlign = response.data.attribute
              this.cardLoading = false
            })
            /*
            //以下可能需要js的引入
            var response = {
              success: false,
              attribute: {
                name: '1',
                region: '2',
                type: '3'
              }
            };
            $.ajax({
              url: '/zc',// 路径
              type: 'get',// 请求方式
              async: false,// 同步访问
              dataType: 'json',//返回结果格式
              data: {'id': this.id, 't': timer},// 传给后台的数据
              scriptCharset: 'utf-8',// 保证返回的数据不会乱码
              success:function(data){
                response = data;
              },
              error:function (e) {
                console.log('请求失败，请稍后再试')
                console.log(e)
              }
            });
            this.formLabelAlign = response.attribute;
            */
          }
        },
        update(){
          this.commitLoading = true
          updateAttribute(this.formLabelAlign).then(response => {
            //保存成功后 作出相应
            this.commitLoading = false
          })
        }
      }
    }
  </script>