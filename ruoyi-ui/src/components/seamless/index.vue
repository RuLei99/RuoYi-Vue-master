<!--
 描述: 新闻无缝滚动
 作者: Jack Chen
 日期: 2020-04-18
-->

<template>
  <div class="wrap-container sn-container"> 
    <div class="sn-content"> 
      <div class="sn-title">预警数据</div> 
      <div class="sn-body"> 
        <div class="wrap-container">

          <div class="table">
            <table border="0" cellpadding="0" cellspacing="0" class="table-header">
              <tbody>
                <tr>
                  <td width="60%">
                    <span>日 期</span>
                  </td>
                  <td width="20%">
                    <span>气温/降雨量</span>
                  </td>
                  <td width="20%">
                    <span>预警类型</span>
                  </td>
                </tr>
              </tbody>
            </table>

            <vue-seamless-scroll :data="listData" class="seamless-warp" :class-option="optionSetting">
              <table border="0" cellpadding="0" cellspacing="0" class="item">
                <tbody>
                  <tr v-for="(item, index) in listData" :key="index">
                    <td width="100%" class="title">
                      <span>{{ item.rq }}</span>
                    </td>
                    <td width="20%">
                      <span>{{ item.data }}</span>
                    </td>
                    <td width="20%">
                      <span>{{ item.lx }}</span>
                    </td>
                  </tr>
                </tbody>
            </table>
            </vue-seamless-scroll>
          </div>

        </div> 
      </div> 
    </div>   
  </div>
</template>

<script>
import vueSeamlessScroll from 'vue-seamless-scroll'
import { ghyj,hhyj,hlyj,rhyj, getDetail, delDetail, addDetail, updateDetail } from "@/api/system/detail";
export default {
  name: "seamless",
  components: {
    vueSeamlessScroll
  },
  data() {
    return {
     listData: new Array()
    }
  },
  computed: {
　　optionSetting () {
      return {
        step: 0.5, // 数值越大速度滚动越快
        limitMoveNum: 2, // 开始无缝滚动的数据量 this.dataList.length
        hoverStop: true, // 是否开启鼠标悬停stop
        direction: 1, // 0向下 1向上 2向左 3向右
        // autoPlay: false,
        openWatch: true, // 开启数据实时监控刷新dom
        singleHeight: 0, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
        singleWidth: 0, // 单步运动停止的宽度(默认值0是无缝不停止的滚动) direction => 2/3
        waitTime: 1000 // 单步运动停止的时间(默认值1000ms)
      }
    }
  },  
  mounted() {
    this.getList();
    this.getList2();
     this.getList3();
     this.getList4();
  },
  methods: {
    getList() {
      ghyj(this.queryParams).then(response => {
        var detailList = response.rows;
      
        for(var i=0;i<detailList.length;i++){
          var obj={'rq':detailList[i].tjDate,'data':detailList[i].jyl,'lx':'干旱'}
          this.listData.push(obj)
        }
      });
    },
    getList2() {
      hlyj(this.queryParams).then(response => {
        var detailList = response.rows;
        console.info(response.rows)
        for(var i=0;i<detailList.length;i++){
          var obj={'rq':detailList[i].tjDate,'data':detailList[i].jyl,'lx':'洪涝'}
          this.listData.push(obj)
        }
        console.info(this.listData)
      });
    },
    getList3() {
      this.loading = true;
      hhyj(this.queryParams).then(response => {
        var detailList = response.rows;
        for(var i=0;i<detailList.length;i++){
          var obj={'rq':detailList[i].tjDate,'data':detailList[i].qw,'lx':'寒害'}
          this.listData.push(obj)
        }
      });
    },
    getList4() {
      rlyj(this.queryParams).then(response => {
        var detailList = response.rows;
        for(var i=0;i<detailList.length;i++){
          var obj={'rq':detailList[i].tjDate,'data':detailList[i].qw,'lx':'热害'}
          this.listData.push(obj)
        }
      });
    },
  },
  beforeDestroy() {
    
  }
};
</script>

<style lang="scss" scoped>
.sn-container {
  left: 1370px;
  top: 110px;
  %table-style {
    width: 100%;
    height: 35px;
    table-layout: fixed;
    tr {
      td {
        padding: 10px 5px;
        text-align: center;
        background-color: transparent;
        white-space: nowrap;
        overflow: hidden;
        color: #E2E5FF;
        font-size: 14px;
      }
    }
  }
  .table {
    .table-header {
      @extend %table-style;
    }
    .seamless-warp {
      height: 400px;
      overflow: hidden;
      visibility: visible;
      .colorRed {
        color: #FF4669;
      }
      .colorOrange {
        color: #FFC956;
      }
      .item {
        height: auto;
        @extend %table-style;
        tr {
          td {
            &.title {
              text-overflow: ellipsis;
              display: inline-block;
            }
          }
        }
      }
    }
  }
}
</style>
