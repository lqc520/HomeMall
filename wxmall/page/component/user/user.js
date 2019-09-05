// page/component/new-pages/user/user.js
Page({
  data:{
    thumb:'',
    nickname:'',
    orders: [{
      "number": "12019082910095533456196895927401",
      "img": "/common/img/paging_img1.jpg",
      "name": "森系小清新四件套",
      "count": 4,
      "status": "待付款",
      "money": 5196.00
    }, {
        "number": "12019082912053917356569723283151",
        "img": "/common/img/beitao3.jpg",
        "name": "森系小清新四件套",
        "count": 1,
        "status": "待付款",
        "money": 2248
      }],
    hasAddress:false,
    address:{}
  },
  onLoad(){
    var self = this;
    /**
     * 获取用户信息
     */
    wx.getUserInfo({
      success: function(res){
        self.setData({
          thumb: res.userInfo.avatarUrl,
          nickname: res.userInfo.nickName
        })
      }
    })

    /**
     * 发起请求获取订单列表信息
     */
    // wx.request({
    //   url: '',
    //   success(res){
    //     self.setData({
    //       orders: res.data
    //     })
    //   }
    // })

  },
  onShow(){
    var self = this;
    /**
     * 获取本地缓存 地址信息
     */
    wx.getStorage({
      key: 'address',
      success: function(res){
        self.setData({
          hasAddress: true,
          address: res.data
        })
      }
    })
  },
  /**
   * 发起支付请求
   */
  payOrders(){
    wx.requestPayment({
      timeStamp: 'String1',
      nonceStr: 'String2',
      package: 'String3',
      signType: 'MD5',
      paySign: 'String4',
      success: function(res){
        console.log(res)
      },
      fail: function(res) {
        wx.showModal({
          title:'支付提示',
          content:'支付测试 成功',
          showCancel: false
        })
      }
    })
  }
})