var Config = (function() {
  // Private static attributes.
  var constants = {//定义了两个常量
  	//宣传广告页
    ADVERTURL: 'http://47.107.145.108/H5MchtPay.html',
    //控制台对外访问地址
    CONSOLEURL: 'http://47.107.145.108',
    //静态资源服务器地址
	  HTMLPAGEURL: 'http://qr.ymcoo.com/pay'
  }
  var xib={};
  // 定义了一个静态方法
  xib.getConstant=function(name){//获取常量的方法
    return constants[name];
  }
  return xib
})();