/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //商品管理
  table.render({
    elem: '#LAY-goods-manage'
    ,url: 'http://mall.lqcnb.cn/api/goods/getList' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 100, title: 'ID', sort: true}
      ,{field: 'name', title: '商品名', minWidth: 100}
      ,{field: 'img', title: '图片', width: 100, templet: '#imgTpl'}
      ,{field: 'price', title: '价格',sort: true,width : 130}
      ,{field: 'stock', title: '库存',sort: true,width : 130}
      ,{field: 'cateName', title: '栏目',width : 130}
      ,{field: 'sortName', width: 80, title: '类别'}
      ,{title: '上架时间',width:250, sort: true,templet:'<div>{{ Format(d.create_time,"yyyy-MM-dd h:m:s")}}</div>'}
      ,{title: '操作', width: 200, align:'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    ,page: true
    ,limit:10
    ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-goods-manage)', function(obj){
    var data = obj.data;
    console.log(data);
    if(obj.event === 'del'){
      layer.prompt({
        formType: 1
        ,title: '敏感操作，请验证口令'
      }, function(value, index){
        if(value=="lqcnb.cn"){
          layer.confirm('真的删除行么', function(index){
            $.ajax({
              url:`http://mall.lqcnb.cn/api/goods/delete/${data.id}`,success:function (res) {
                layer.msg(res.msg);
              }
            });
            obj.del();
            layer.close(index);
          });
        }else{
          layer.msg("口令错误");
        }
        layer.close(index);
        

      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);
      // layer.msg(JSON.parse(tr));
      layer.open({
        type: 2
        ,title: '编辑商品'
        ,content: '/views/goods/goodsform.html?id='+data.id+"&name="+data.name
            +"&price="+data.price+"&stock="+data.stock+"&file="+data.img
            +"&sortId="+data.sort_id+"&seasonId="+data.season_id+
            "&categoryId="+data.category_id
        ,maxmin: true
        ,area: ['500px', '450px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'LAY-goods-front-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //     body = layer.getChildFrame('body', index);
          // body.find('#name').val(data.name);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            console.log(field);
            //提交 Ajax 成功后，静态更新表格中的数据

             $.ajax({
               url:'http://mall.lqcnb.cn/api/goods/update',
               data:field,
               success:function (data) {
                 layer.msg(data.msg);
               }
             }).done(function () {
               table.reload('LAY-order-manage'); //数据刷新
               layer.close(index); //关闭弹层
             });

          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){
          
        }
      });
    }
  });

  //订单管理
  table.render({
    elem: '#LAY-order-manage'
    ,url: 'http://mall.lqcnb.cn/api/order/getOrderList' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'order_number', width: 100, title: '订单编号', sort: true}
      ,{field: 'goods_name', title: '商品名', minWidth: 100}
      ,{field: 'goods_img', title: '图片', width: 100, templet: '#imgTpl'}
      ,{field: 'goods_price', title: '价格',sort: true,width : 130}
      ,{field: 'payment_number', title: '支付单号',width : 130}
      ,{field: 'order_status', title: '订单状态',templet: '#stateTpl'}
      // ,{field: 'sortName', width: 80, title: '类别'}
      ,{title: '创建时间',width:250, sort: true,templet:'<div>{{ Format(d.create_time,"yyyy-MM-dd h:m:s")}}</div>'}
      ,{title: '操作', width: 200, align:'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    ,page: true
    ,limit:10
    ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
  });

  //监听工具条
  table.on('tool(LAY-order-manage)', function(obj){
    var data = obj.data;
    console.log(data);
    if(obj.event === 'del'){
      layer.prompt({
        formType: 1
        ,title: '敏感操作，请验证口令'
      }, function(value, index){
        if(value=="lqcnb.cn"){
          layer.confirm('真的删除行么', function(index){
            $.ajax({
              url:`http://mall.lqcnb.cn/api/goods/delete/${data.id}`,success:function (res) {
                layer.msg(res.msg);
              }
            });
            obj.del();
            layer.close(index);
          });
        }else{
          layer.msg("口令错误");
        }
        layer.close(index);


      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);
      // layer.msg(JSON.parse(tr));
      layer.open({
        type: 2
        ,title: '编辑订单'
        ,content: '/views/goods/order/orderform.html?orderNumber='+data.order_number+"&orderStatus="+data.order_status
        ,maxmin: true
        ,area: ['500px', '350px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
              ,submitID = 'LAY-order-front-submit'
              ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //  let body = layer.getChildFrame('body', index);
          // body.find('#orderNumber').val(data.order_number);
          // body.find('#order_status').val(data.order_status);
          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            console.log(field);
            //提交 Ajax 成功后，静态更新表格中的数据

            $.ajax({
              url:'http://mall.lqcnb.cn/api/order/update',
              data:field,
              success:function (data) {
                layer.msg(data.msg);
              }
            }).done(function () {
              table.reload('LAY-order-manage'); //数据刷新
              layer.close(index); //关闭弹层
            });

          });

          submit.trigger('click');
        }
        ,success: function(layero, index){

        }
      });
    }
  });


  //支付管理
  table.render({
    elem: '#LAY-pay-manage'
    ,url: 'http://mall.lqcnb.cn/api/pay/list' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 100, title: 'ID', sort: true}
      ,{field: 'memberId', title: '用户id', width: 100}
      ,{field: 'paymentType', title: '支付类型', width: 100, templet: '#payTpl'}
      ,{field: 'paymentNumber', title: '支付订单',sort: true,width : 130}
      ,{field: 'paymentAmount', title: '支付金额',width : 130}
      ,{field: 'paymentStatus', title: '订单状态',templet: '#stateTpl'}
      ,{title: '创建时间',width:250, sort: true,templet:'<div>{{ Format(d.createTime,"yyyy-MM-dd h:m:s")}}</div>'}
      ,{title: '操作', width: 200, align:'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    ,page: true
    ,limit:10
    ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
  });

  //监听工具条
  table.on('tool(LAY-order-manage)', function(obj){
    var data = obj.data;
    console.log(data);
    if(obj.event === 'del'){
      layer.prompt({
        formType: 1
        ,title: '敏感操作，请验证口令'
      }, function(value, index){
        if(value=="lqcnb.cn"){
          layer.confirm('真的删除行么', function(index){
            $.ajax({
              url:`http://mall.lqcnb.cn/api/goods/delete/${data.id}`,success:function (res) {
                layer.msg(res.msg);
              }
            });
            obj.del();
            layer.close(index);
          });
        }else{
          layer.msg("口令错误");
        }
        layer.close(index);


      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);
      // layer.msg(JSON.parse(tr));
      layer.open({
        type: 2
        ,title: '编辑订单'
        ,content: '/views/goods/order/orderform.html?orderNumber='+data.order_number+"&orderStatus="+data.order_status
        ,maxmin: true
        ,area: ['500px', '350px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
              ,submitID = 'LAY-order-front-submit'
              ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //  let body = layer.getChildFrame('body', index);
          // body.find('#orderNumber').val(data.order_number);
          // body.find('#order_status').val(data.order_status);
          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            console.log(field);
            //提交 Ajax 成功后，静态更新表格中的数据

            $.ajax({
              url:'http://mall.lqcnb.cn/api/order/update',
              data:field,
              success:function (data) {
                layer.msg(data.msg);
              }
            }).done(function () {
              table.reload('LAY-order-manage'); //数据刷新
              layer.close(index); //关闭弹层
            });

          });

          submit.trigger('click');
        }
        ,success: function(layero, index){

        }
      });
    }
  });


  exports('goods', {})
});