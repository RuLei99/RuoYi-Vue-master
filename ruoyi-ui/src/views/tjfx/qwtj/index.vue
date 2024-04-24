<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true">
      <el-form-item label="地区" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入地区名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
    
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="query();" >预测</el-button>
        <el-button icon="el-icon-refresh" size="mini">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="20">
  <!-- <el-col :span="12"  >
    <div id="main1" style="width: 100%;height:800px;"></div>
  </el-col> -->
  <el-col :span="24"  >
      <div id="main2" style="width: 100%;height:800px;"></div>
  </el-col>
</el-row>
  
  </div>
</template>

<script>
import * as echarts from "echarts"

import {qwyc} from '@/api/system/detail'
export default {
  name: "qxyj",
  data() {
    return {
      xdata:['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
      ydata:[5, 20, 36, 10, 10, 20],
      queryParams:{
          city: ''
      }
    };
  },
  created() {
  },
  mounted() {
    //this.loadBar();
  },
  methods: {

    // 用来加载柱状图
    query(){
      qwyc(this.queryParams.city).then(resp=>{
        // var myChart = echarts.init(document.getElementById('main1'));
        // var option = {
        //   title: [
        //         {
        //           text: '学生消费排名',
        //           left: '25%',
        //           textAlign: 'center'
        //         }
        //       ],
        //   xAxis: {
        //     type: 'category',
        //     data: resp.data.names
        //   },
        //   yAxis: {
        //     type: 'value'
        //   },
        //   series: [
        //     {
        //       data: resp.data.tjje,
        //       type: 'bar',
        //       showBackground: true,
        //       backgroundStyle: {
        //         color: 'rgba(180, 180, 180, 0.2)'
        //       }
        //     }
        //   ]
        // };
        // myChart.setOption(option) 

        var myChart2 = echarts.init(document.getElementById('main2'));
        var option2 = {
          title: {
            text: '未来5日气温预测'
          },
          tooltip:{
              trigger:'item'
          },
          xAxis: {
              type: 'category',
              data: resp.data.sj
            },
            yAxis: {
              type: 'value'
            },
            series: [
              {
                data: resp.data.qw,
                type: 'line',
                smooth: true
              }
            ]
        };
        myChart2.setOption(option2) 
      })
        
   }
  }
};
</script>
