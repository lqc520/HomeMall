// const ApiRootUrl = 'http://mall.lqcnb.cn/api';
const ApiRootUrl = 'http://localhost:9989/api';
module.exports = {
  getRandList: ApiRootUrl + "/goods/getRandList",
  getSortList: ApiRootUrl +"/sort/list",
  getcategoryList: ApiRootUrl + "/category/list", 
  getwxList: ApiRootUrl + "/sort/wxList",
  getListBySortId: ApiRootUrl +"/goods/getListBySortId/",
  getDetail: ApiRootUrl +"/goods/getById/",
  getSeach: ApiRootUrl +"/goods/search/",
  getHot: ApiRootUrl +"/goods/getHot"
};