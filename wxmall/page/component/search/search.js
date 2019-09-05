let timeId = null;
var api=require('../../../config/api.js');
Page({
    data: {
        history: [],
        hot: ['森系小清新', '轻奢吊灯', '收纳'],
        result: [],
        searchName:'',
        hotGoods:[],
        showKeywords: false,
      keywords: ['森系小清新', '轻奢吊灯', '收纳储物柜', '电磁炉'],
        value: '',
        showResult: false,
    },
    getSearch(){
      let self = this;
      let serachUrl='';
      if(self.data.searchName){
        serachUrl = api.getSeach  + self.data.searchName;
        this.historyHandle(self.data.searchName);
      }else{
        serachUrl = api.getSeach +"-1";
      }
      wx.request({
        url: serachUrl,
        success(res) {
          console.log(res.data);
          self.setData({
            result: res.data,
            showKeywords: false,
            showResult: true
    
          })
        }
      })
    },
    cancelSearch() {
        this.setData({
            showResult: false,
            showKeywords: false,
            value: ''
        })
    },
    searchInput(e) {
      console.log(e.detail.value);
        if(!e.detail.value){
            this.setData({
                showKeywords: false
            })
        }else{
            this.setData({
              searchName: e.detail.value
            })
            if(!this.data.showKeywords){
                timeId && clearTimeout(timeId);
                timeId = setTimeout(() => {
                    this.setData({
                        showKeywords: true
                    })
                }, 1000)
            }
        }
    },
    keywordHandle(e) {
        const text = e.target.dataset.text;
        
        this.setData({
          searchName: text
        })
        this.getSearch();
        this.historyHandle(text);
    },
    historyHandle(value) {
        let history = this.data.history;
        const idx = history.indexOf(value);
        if (idx === -1) {
            // 搜索记录只保留8个
            if (history.length > 7) {
                history.pop();
            }
        } else {
            history.splice(idx, 1);
        }
        history.unshift(value);
        wx.setStorageSync('history', JSON.stringify(history));
        this.setData({
            history
        });
    },
    onLoad() {
        const history = wx.getStorageSync('history');
        if (history) {
            this.setData({
                history: JSON.parse(history)
            })
            console.log(this.data.history);
        }
        let self=this;
        wx.request({
          url: api.getHot,
          success(res){
              self.setData({
                hotGoods:res.data.data
              })
          }
        })
    }
})