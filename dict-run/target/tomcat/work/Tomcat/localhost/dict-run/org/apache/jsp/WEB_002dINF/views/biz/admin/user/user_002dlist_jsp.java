/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-23 07:01:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.biz.admin.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/include/taglibs.jsp", Long.valueOf(1500539076112L));
    _jspx_dependants.put("/WEB-INF/views/include/top.jsp", Long.valueOf(1500394090218L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

// Object version=request.getAttribute("version");
    Object versionObj = request.getAttribute("versionMap");
    if (versionObj == null) {
        versionObj = new Object();
    }
    String versionJson = "{}";
    if (request.getAttribute("versionJson") != null) {
        versionJson = request.getAttribute("versionJson").toString();
    }


      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/include/taglibs.jsp(20,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("ctx");
      // /WEB-INF/views/include/taglibs.jsp(20,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f1.setParent(null);
      // /WEB-INF/views/include/taglibs.jsp(21,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setVar("ctxAssets");
      // /WEB-INF/views/include/taglibs.jsp(21,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setValue(basePath + "/assets/" );
      int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
      if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f2.setParent(null);
      // /WEB-INF/views/include/taglibs.jsp(22,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setVar("jsRoot");
      // /WEB-INF/views/include/taglibs.jsp(22,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setValue(basePath + "/assets/js/" );
      int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
      if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f3.setParent(null);
      // /WEB-INF/views/include/taglibs.jsp(23,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setVar("mjsRoot");
      // /WEB-INF/views/include/taglibs.jsp(23,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setValue(basePath + "/assets/mobile/js/" );
      int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
      if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f4.setParent(null);
      // /WEB-INF/views/include/taglibs.jsp(24,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f4.setVar("v");
      // /WEB-INF/views/include/taglibs.jsp(24,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f4.setValue(versionObj);
      int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
      if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      if (_jspx_meth_c_005fset_005f5(_jspx_page_context))
        return;
      out.write("<script>\r\n");
      out.write("    var version =");
      out.print(versionJson);
      out.write(";\r\n");
      out.write("</script>");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"description\" content=\"overview & stats\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("<!-- basic styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/font-awesome/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/jgGrid/ui.jqgrid-bootstrap.css\">\r\n");
      out.write("<!-- messenger styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/messenger/messenger.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/messenger/messenger-theme-future.css\">\r\n");
      out.write("<!--jqueryMCustomScrollBar-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/jquery-mCustomScrollbar/jquery.mCustomScrollbar.min.css\">\r\n");
      out.write("<!-- zrw styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/zrw.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/css/global.css\">\r\n");
      out.write("<script>\r\n");
      out.write("    //basePath 定义在taglibs.jsp中\r\n");
      out.write("    G_WEB_ROOT = \"");
      out.print(basePath);
      out.write("\";\r\n");
      out.write("    var iframe = window.parent.document.getElementById(\"mainFrame\");\r\n");
      out.write("    var gotoBack = function () {\r\n");
      out.write("//     \talert();\r\n");
      out.write("    };\r\n");
      out.write("    if (iframe) {\r\n");
      out.write("        window.onclick = function () {\r\n");
      out.write("            window.parent.closeMessage();\r\n");
      out.write("        };\r\n");
      out.write("        gotoBack = window.parent.gotoRecordPage;\r\n");
      out.write("    } else if (typeof(\"gotoRecordPage\") == \"function\") {\r\n");
      out.write("        gotoBack = gotoRecordPage;\r\n");
      out.write("    }\r\n");
      out.write("    addEventHandler(window, 'keydown', function (event) {\r\n");
      out.write("        if (event.keyCode == 8) {\r\n");
      out.write("            var elem = event.srcElement;\r\n");
      out.write("            var name = elem.nodeName;\r\n");
      out.write("//             console.log(name);\r\n");
      out.write("//             if(name!='INPUT' && name!='TEXTAREA'){  \r\n");
      out.write("//                 event.returnValue = false ;  \r\n");
      out.write("//                 gotoBack();\r\n");
      out.write("//                 return ;  \r\n");
      out.write("//             }  \r\n");
      out.write("//             var type_e = elem.type.toUpperCase();  \r\n");
      out.write("            if (name != 'INPUT' && name != 'TEXT' && name != 'NUMBER' && name != 'TEXTAREA' && name != 'PASSWORD' && name != 'FILE') {\r\n");
      out.write("                event.returnValue = false;\r\n");
      out.write("                gotoBack();\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("            if (name == 'INPUT' && (elem.readOnly == true || elem.disabled == true)) {\r\n");
      out.write("                event.returnValue = false;\r\n");
      out.write("                gotoBack();\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    function addEventHandler(obj, eventName, fun, param) {\r\n");
      out.write("        var fn = fun;\r\n");
      out.write("        if (param) {\r\n");
      out.write("            fn = function (e) {\r\n");
      out.write("                fun.call(this, param);  //继承监听函数,并传入参数以初始化;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        if (obj.attachEvent) {\r\n");
      out.write("            obj.attachEvent('on' + eventName, fn);\r\n");
      out.write("        } else if (obj.addEventListener) {\r\n");
      out.write("            obj.addEventListener(eventName, fn, false);\r\n");
      out.write("        } else {\r\n");
      out.write("            obj[\"on\" + eventName] = fn;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var dataZoom = {\r\n");
      out.write("        show: true,\r\n");
      out.write("        realtime: true,\r\n");
      out.write("        y: 1,\r\n");
      out.write("        height: 20,\r\n");
      out.write("//        backgroundColor: 'rgba(255,255,255,0.5)',\r\n");
      out.write("//        dataBackgroundColor: 'rgba(255,255,240,0.5)',\r\n");
      out.write("//        fillerColor: 'rgba(211 ,211 ,211 ,0.6)',\r\n");
      out.write("//        handleColor: 'rgba(100,100,100,0.8)',\r\n");
      out.write("        zoomLock: true,   //当设置为true时选择区域不能伸缩\r\n");
      out.write("        showDetail: false,\r\n");
      out.write("        handleSize: 40,\r\n");
      out.write("        start: 0,\r\n");
      out.write("        end: 40\r\n");
      out.write("    };\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jsRoot}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("require.js\"></script>\r\n");
      out.write("\t\t");
      out.write("<title>用户管理</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxAssets}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("plugin/datatables/css/jquery.dataTables.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write(".glyphiconColor {\r\n");
      out.write("\tcolor: #0099cc\r\n");
      out.write("}\r\n");
      out.write(".dataTables_wrapper .row:first-child {\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"rightBody\">\r\n");
      out.write("\t\t<div class=\"SetUpBody\">\r\n");
      out.write("\t\t\t<div class=\"index-common-title bottom-title\">\r\n");
      out.write("\t\t\t\t<div class=\"index-common-title-left bottom-left\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"index-common-title-text bottom-text\">用户配置</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"bottom-div bottom-div2 clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-12 ct-col1\">\r\n");
      out.write("\t\t\t\t\t<table id=\"example\" class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th><input type=\"checkbox\" name=\"allChecked\" /></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>序号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>用户编码</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>用户名称</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>角色描述</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>创建时间</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>修改时间</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"index-common-title bottom-title\">\r\n");
      out.write("\t\t\t\t<div class=\"index-common-title-left bottom-left\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"index-common-title-text bottom-text\">用户信息</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"bottom-div bottom-div2 clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-12 ct-col1\">\r\n");
      out.write("\t\t\t\t\t<table id=\"infoTable\" class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>用户编码</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>用户名称</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>角色范围</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>功能权限范围</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- \t\t\t\t\t\t\t\t<th>数据权限范围</th> -->\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 功能(Modal) -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"userRoleModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"userRoleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-hidden=\"true\">×</button>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"roleUserId\" name=\"userId\">\r\n");
      out.write("\t\t\t\t\t<h3 class=\"modal-title\" id=\"userRoleModalLabel\">\r\n");
      out.write("\t\t\t\t\t\t用户角色配置 <small>&nbsp;</small>\r\n");
      out.write("\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\" style=\"margin: 0;\" id=\"modalPanel\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3 class=\"panel-title\">未选角色</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"list-group\" id=\"notSelectPanel\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\" col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3 class=\"panel-title\">已选角色</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"list-group\" id=\"isSelectPanel\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"confirmRoleBtn\">提交</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.modal-content -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.modal-dialog -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- 搜索弹出框 -->\r\n");
      out.write("\t<div id=\"searchModal\" class=\"modal fade\" data-backdrop=\"static\"\r\n");
      out.write("\t\ttabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"searchUserId\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<h3 class=\"modal-title\">绑定员工</h3>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-7\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control search-query\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"searchTxt\" placeholder=\"请输入员工ID/姓名\" /> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"input-group-btn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-white\" id=\"searchBtn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t查询 <i class=\"icon-search icon-on-right bigger-110\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-5\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>* 姓名支持模糊查询</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-12 column\" id=\"searchEmpTable\">\r\n");
      out.write("\t\t\t\t\t\t\t<table id=\"searchEmpGrid\"></table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.modal-content -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.modal-dialog -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/js/biz/admin/userListDT.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent(null);
    // /WEB-INF/views/include/taglibs.jsp(26,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setVar("sysName");
    // /WEB-INF/views/include/taglibs.jsp(26,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/include/taglibs.jsp(26,0) '字典后台'",_el_expressionfactory.createValueExpression("字典后台",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }
}
