var api = require('../../config/api.js');
Page({
  data: {
    imgUrls: [
      '/image/banner1.jpg',
      '/image/bannerV1.jpg',
      '/image/b1.jpg',
      '/common/img/us_img2.jpg'
    ],
    indicatorDots: false,
    autoplay: false,
    interval: 3000,
    duration: 800,
    newList:[]
  },
  onLoad: function (options){
    let that=this;
    wx.request({
      url: api.getRandList, //仅为示例，并非真实的接口地址
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res) {
        console.log(res.data)
        that.setData({
          newList:res.data.data
        })
      }
    })
  }
})