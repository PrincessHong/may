
$(document).ready(
  function () {
    var submitResult = true;// 总的验证 
    $("#rawScoreForm").submit(function () {
      submitResult = true;
      $("#rv").change();
      $("#bd").change();
      $("#pm").change();
      $("#inf").change();
      $("#oa").change();
      $("#zl").change();
      $("#pn").change();
      
      if (submitResult) {//防止多次提交
        $("#submitbutton").attr("disabled", true);
        $("#submitbutton").attr("style", "background-color:#ECE9D8;");
        $("#resetbutton").attr("disabled", true);
        $("#resetbutton").attr("style", "background-color:#ECE9D8;");
      } else {
    	alert("请输入有效范围内的值！");
      }
      return submitResult;
    });

    $("#rv").change(function () {
      $.test($(this), 31 , -1);
    });
    $("#bd").change(function () {
      $.test($(this), 34 , -1);
    });
    $("#pm").change(function () {
      $.test($(this), 35 , -1);
    });
    $("#inf").change(function () {
        $.test($(this), 29 , -1);
    });
    $("#oa").change(function () {
        $.test($(this), 32 , -1);
    });
    $("#zl").change(function (){
    	$.test($(this), 20, -1);
    });
    $("#pn").change(function (){
    	$.test($(this), 24, -1);
    });
    $.extend({
        test: function (e, v, el) {
          reg = /^[0-9fu]*$/;
          if (!isNaN(parseInt(e.val()))) {
            if (reg.test(e.val())) {
              if (parseInt(e.val()) >= 0
                && parseInt(e.val()) <= v
                && parseInt(e.val()) != el) {
                e.removeClass("wrong");
                return true;
              } else {
                submitResult = false;
                e.addClass("wrong");
                return false;
              }
            } else {
              e.addClass("wrong");
              submitResult = false;
              return false;
            }
          } else if (e.val() != "") {
            if (reg.test(e.val())) {
              e.removeClass("wrong");
              return true;
            } else {
              submitResult = false;
              e.addClass("wrong");
              return false;
            }
          } else if (e.val() == "") {
            // submitResult = true;
            e.removeClass("wrong");
            return true;
          }
        }
    });
  });