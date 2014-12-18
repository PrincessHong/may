/*验证日期函数*/

function check(e, f, l) {
  if (isNaN(parseInt(e.val()))) {
    e.addClass("wrong");
    return false;
  } else {
    if (parseInt(e.val()) < f || parseInt(e.val()) > l) {
      e.addClass("wrong");
      return false;
    } else {
      e.removeClass("wrong");
      return true;
    }
  }
}

function CalDays(year, month, day) {
  if (!isNaN(year.val()) && !isNaN(month.val())) {
    var date = new Date(year.val(), month.val(), 0);
    if (day.val() <= date.getDate()) {
      day.removeClass("wrong");
      return true;
    } else {
      day.addClass("wrong");
      return false;
    }
  } else {
    return false;
  }
}


$(document)
  .ready(
  function () {
    var ageArry = [ 0, 0, 0 ];
    var submitResult = true;// 总的验证
    $("#childInfoForm").submit(function () {
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

    // 日期
    $("#cTYear").change(function () {
      $.calculateAge(ageArry, $(this));
    });
    $("#cTMonth").change(function () {
      $.calculateAge(ageArry, $(this));
    });
    $("#cTDay").change(function () {
      $.calculateAge(ageArry, $(this));
    });
    $("#cBYear").change(function () {
      $.calculateAge(ageArry, $(this));
    });
    $("#cBMonth").change(function () {
      $.calculateAge(ageArry, $(this));
    });
    $("#cBDay").change(function () {
      $.calculateAge(ageArry, $(this));
    });

    // 扩展方法
    $.extend({
      calculateAge: function (ageArry, e)// 计算年龄
      {
        if (!isNaN(parseInt($("#cTYear").val()))
          && !isNaN(parseInt($("#cTMonth")
            .val()))
          && !isNaN(parseInt($("#cTDay")
            .val()))
          && !isNaN(parseInt($("#cBYear")
            .val()))
          && !isNaN(parseInt($("#cBMonth")
            .val()))
          && !isNaN(parseInt($("#cBDay")
            .val()))) {
          var TYear = parseInt($("#cTYear").val());
          var TMonth = parseInt($("#cTMonth")
            .val());
          var TDay = parseInt($("#cTDay").val());
          var BYear = parseInt($("#cBYear").val());
          var BMonth = parseInt($("#cBMonth")
            .val());
          var BDay = parseInt($("#cBDay").val());

          if (check($("#cTYear"), 2014, 2050)
            && check($("#cTMonth"), 1, 12)
            && check($("#cTDay"), 1, 31)
            && check($("#cBYear"), 2007, 2050)
            && check($("#cBMonth"), 1, 12)
            && check($("#cBDay"), 1, 31)
            && CalDays($("#cTYear"),
              $("#cTMonth"),
              $("#cTDay"))
            && CalDays($("#cBYear"),
              $("#cBMonth"),
              $("#cBDay"))) {

            var vDay, vMonth, vYear;
            if (TDay < BDay)// 小于时，借位
            {
              TMonth = TMonth - 1;
              TDay = TDay + 30;
              vDay = TDay - BDay;

              if (TMonth < BMonth) {
                TYear = TYear - 1;
                TMonth = TMonth + 12;
                vMonth = TMonth - BMonth;
              } else {
                vMonth = TMonth - BMonth;
              }
              vYear = TYear - BYear;
            }
            if (TDay >= BDay)// 大于时，正常减
            {
              vDay = TDay - BDay;
              if (TMonth >= BMonth) {
                vMonth = TMonth - BMonth;
              } else {
                TYear = TYear - 1;
                TMonth = TMonth + 12;
                vMonth = TMonth - BMonth;
              }
              vYear = TYear - BYear;
            }
            var flag = true;
            if ($('#type').val() ==1) {
              if( (vYear < 2 || vYear > 3) || ( vYear == 2 && vMonth < 6) ) {
                flag = false;
              } 
            } else if( $('#type').val() == 4 ) {
              if ( vYear < 4 || vYear > 6 ) {
                flag = false;
              }
            }
            if ( flag ){
              $("#hideAgeResult").attr(
                  "value",
                    vYear + "岁" + vMonth
                    + "月" + vDay
                    + "天");
              ageArry[0] = vYear;
              ageArry[1] = vMonth;
              ageArry[2] = vDay;
              submitResult = true;
            } else {
               $("#hideAgeResult").attr(
                  "value",
                    vYear + "岁" + vMonth
                    + "月" + vDay
                    + "天");
                alert("警告：儿童年龄超出计算范围，请检查输入是否有误！");
            }
          } else {
            alert("输入日期有误");
          }
        } else {
          submitResult = false;// 总验证通过
        }
      }
    });

  });