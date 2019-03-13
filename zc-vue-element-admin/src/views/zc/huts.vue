<template>
    <div >
        <el-row :gutter="20" class="center">
            <el-col :span="6" v-for="hut in hutList">
                <router-link :to="'/zc/love/'+hut.id">
                    <el-card class="grid-content bg-purple" >
                        <label>{{ hut.name }}</label>
                    </el-card>
                </router-link>
            </el-col>
        </el-row>
    </div>
</template>
<script>
    import { getUserHuts } from '@/api/zc'

    export default {
        'name': 'huts',
        data () {
            return {
                hutList: []
            }
        },
        created () {
            this.getHuts()
        },
        methods: {
            getHuts(){
                getUserHuts().then(response => {
                    this.hutList = response.data.hutList
                    console.log(this.hutList)
                })
            }
        }

    }
</script>
<style>
    .center {
        text-align: center;
    }
    .el-row {
        margin-bottom: 20px;
        &:last-child {
        margin-bottom: 0;
        }
    }
    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>