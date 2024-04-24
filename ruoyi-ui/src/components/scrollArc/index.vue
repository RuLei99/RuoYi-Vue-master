<!--
 描述: 滚动弧形线
 作者: Jack Chen
 日期: 2020-04-20
-->

<template>
  <div class="wrap-container sn-container"> 
    <div class="sn-content"> 
      <div class="sn-title">气压预测</div> 
      <div class="sn-body"> 
        <div class="wrap-container"> 
          <div class="chartsdom" id="chart_arc"></div>
        </div> 
      </div> 
    </div>   
  </div>
</template>

<script>
import * as echarts from "echarts"
import {qyyc} from '@/api/system/detail'
export default {
  name: "scrollArc",
  data() {
    return {
      option: null,
      number: 0, // 播放所在下标
      timer: null,
      xData: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
      data: [54, 86, 46, 77, 96, 89, 88, 23, 38, 3, 66, 98]
    }
  },
  mounted() {
    this.getEchart();
  },
  methods: {
    getEchart() {
      qyyc(this.queryParams.city).then(resp=>{
       
        var myChart2 = echarts.init(document.getElementById('chart_arc'));
        var option2 = {
          title: {
            text: '未来5日气压预测'
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
  },
  beforeDestroy() {
    clearInterval(this.timer);
  }
};
</script>

<style lang="scss" scoped>
.sn-container {
  left: 50px;
  top: 690px;
  width: 895px;
  height: 400px;
  .chartsdom {
    width: 100%;
    height: 95%;
  }
}
</style>
