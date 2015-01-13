<%@ page language="java" import="java.util.*" pageEncoding="Utf-8" %>
<%@ page language="java" import="com.kingmay.beans.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <jsp:include page="lib.jsp"></jsp:include>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">京美心理测评</a>
        </div>
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="getThisChildAction.action">记分首页</a></li>
                <li class="dropdown"><a href="child.jsp"
                                        class="dropdown-toggle" data-toggle="dropdown">数据录入 <span
                        class="caret"></span> </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="child.jsp">2:6-3:11</a>
                        </li>
                        <li class="divider">el</li>
                        <li><a href="child4.jsp">4:0-6:11</a>
                        </li>
                    </ul>
                </li>
                <li class="active"><a href="goChangeInfoAction">信息维护</a></li>
                <li><a href="userLogoutAction.action">退出</a></li>
            </ul>
        </div>
    </div>

</nav>
<div style="height:70px"></div>

<div id="main-content">
    <div class="container">

        <a href="goChangeInfoAction" class="btn btn-link " id="btn_info">个人资料</a> \ <a
            href="changepwd.jsp" class="btn btn-link" id="btn_chpwd">修改密码</a>

        <div class="row" id="info">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <div align="center">
                    <h3>
                        <b>个人资料</b><br/>
                    </h3>
                </div>
                <br/> <br/> <br/>

                <form class="form-horizontal" role="form" action="changeInfoAction" method="post">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">主试姓名</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.uname }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">主试编号</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.uid }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">2:6-3:11可用</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.ucanuse }份</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">4:0-6:11可用</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.ucanuse4 }份</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">E-mail地址</label>

                            <div class="col-sm-8">
                                <input type="email" class="form-control" id="uemail" placeholder="邮箱" name="u.uemail"
                                       value=${u.uemail }>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">公司主页</label>

                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="ucom" name="u.ucom" placeholder="公司主页"
                                       value=${u.ucom }>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">身份证号码</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.uiden }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">记分系统登录名</label>

                            <div class="col-sm-8">
                                <input type="text" class="form-control"
                                       id="ulname" placeholder="登录名" disabled name="u.ulname" value=${u.ulname }>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">2:0-3:11已用</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.uused }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">4:0-6:11已用</label>

                            <div class="col-sm-8">
                                <p class="form-control-static">${u.uused4 }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="utel">联系电话</label>

                            <div class="col-sm-8">
                                <input type="tel" class="form-control"
                                       id="utel" placeholder="联系电话" name="u.utel" value=${u.utel }>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">单位名称</label>

                            <div class="col-sm-8">
                                <input type="tel" class="form-control"
                                       id="ucomadd" placeholder="单位名称" name="u.ucomadd" value=${u.ucomadd } disabled>
                            </div>
                        </div>
                    </div>

                    <div align="right" style="padding:30px">
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </form>
            </div>
            <div class="col-md-1"></div>
        </div>

        <div style="height:5px"></div>
    </div>
</div>
<div style="height:30px"></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
