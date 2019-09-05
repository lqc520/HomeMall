// page/component/details/details.js
var api = require('../../../config/api.js');
Page({
  data:{
    product:{},
    dimg:[],
    goods: {
      id: 1,
      price: 0.01,
      stock: '有货',
      parameter: '参数待开发',
      service: '不支持退货'
    },
    num: 1,
    totalNum: 0,
    hasCarts: false,
    curIndex: 0,
    show: false,
    scaleCart: false
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var self = this;
    wx.request({
      url: api.getDetail + options.id,
      success(res) {
        console.log(res.data.detailImg.split(','));
        self.setData({
          product: res.data,
          dimg: res.data.detailImg.split(',')
        })
      }
    })

  },
  addCount() {
    let num = this.data.num;
    num++;
    this.setData({
      num : num
    })
  },

  addToCart() {
    const self = this;
    const num = this.data.num;
    let total = this.data.totalNum;

    self.setData({
      show: true
    })
    setTimeout( function() {
      self.setData({
        show: false,
        scaleCart : true
      })
      setTimeout( function() {
        self.setData({
          scaleCart: false,
          hasCarts : true,
          totalNum: num + total
        })
      }, 200)
    }, 300)

  },

  bindTap(e) {
    const index = parseInt(e.currentTarget.dataset.index);
    this.setData({
      curIndex: index
    })
  }
 
})