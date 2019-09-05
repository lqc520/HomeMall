var api=require('../../../config/api.js');
Page({
    data: {
        category: [
          { name: '首页', id:'home'},
          { name: '居家用品', id:'house'},
          { name: '小家电', id:'small'},
          { name: '洗护', id:'wash'},
          { name: '厨具', id:'kitchen'},
          { name: '日用品', id:'daily'}
        ],
        detail:[],
        curIndex: 0,
        isScroll: false,
      toView: 'home'
    },
    onReady(){
        var self = this;
        wx.request({
            url:api.getwxList,
            success(res){
                self.setData({
                    detail : res.data
                })
            }
        });
      // wx.request({
      //   url: api.getcategoryList,
      //   success(res) {
      //     console.log(res.data);
      //     self.setData({
      //       category: res.data
      //     })
      //   }
      // })
      // wx.request({
      //   url: api.getSortList,
      //   success(res) {
      //     console.log(res.data);
      //     self.setData({
      //       sort: res.data
      //     })
      //   }
      // })
    },
    switchTab(e){
      const self = this;
      this.setData({
        isScroll: true
      })
      setTimeout(function(){
        self.setData({
          toView: e.target.dataset.id,
          curIndex: e.target.dataset.index
        })
      },0)
      setTimeout(function () {
        self.setData({
          isScroll: false
        })
      },1)
        
    }
    
})