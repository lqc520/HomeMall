// page/component/list/list.js
var api=require('../../../config/api.js')
Page({
  data:{
    sortList:[]
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
   var self=this;
    wx.request({
      url: api.getListBySortId + options.id,
      success(res){
        console.log(res.data)
        self.setData({
          sortList:res.data
        })
      }
    })

  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  }
})