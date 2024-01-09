<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- <.%@ page import="java.util.ArrayList,com.freeeat.feed.model.vo.Feed" %>  -->


<!--<.%.@ page import="java.util.ArrayList,com.freeeat.review.model.vo.Review" %> -->

<!--%
      
    ArrayList<Feed> feed = (ArrayList<Feed>)request.getAttribute("feed");
        int feedCount = (int)request.getAttribute("feedCount");
        int reviewCount = (int)request.getAttribute("reviewCount");
        int wishCount = (int)request.getAttribute("wishCount");
%>  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>



    .left_Area{
        display: inline-block;
        width:400px;
        height:300px;
        justify-content: center; 
        align-items: center;
        border : 3px solid #C8E183;
        border-radius: 5%;
       }
      


    .right_Area{
        display: inline-block;
        width:400px;
        height:300px;
        justify-content: center; 
        align-items: center;
        border : 3px solid #C8E183;
        border-radius: 5%;
    }
    
   
    
    table td {
    /* width: 150px; */
    height: 30px;


    }

     div>img {
        width :60px; 
        height :40px;
        
        padding-top: 10px;
        padding-right: 10px;
        padding-bottom: 1px;
        padding-left: 10px;
     }
    
    .thumbnail{
		
		width: 70px;
		display:inline-block;
		margin: 6px;
		
	}

 

    button {
        background-color: #C8E183;
        color: white;
        border: #C8E183;
        border-radius: 10%;
    }

    button:active {
  box-shadow: 1px 1px 0 rgb(0,0,0,0.5);
  position: relative;
  background-color: #b7cf72;
 
} 

table td {

    border-radius: 10%;
   

}

#btn {
    width: 100px;
    height: 22px;
    font-size: 15px;
    color: rgb(53, 52, 52);
}





   
</style>
</head>

<body>
    <%@ include file= "../common/menubar_hj.jsp" %>
    
    <%	String memId = loginMem.getMemId();
    	String memNickName = loginMem.getMemNickName();
        String phone = loginMem.getPhone();
        String birthDate = loginMem.getBirthDate();
        String email = loginMem.getEmail();
        String residence = loginMem.getResidence();
        
    %>
    
    
    <br><br><br><br>


<div align="center">

    




    <table align="center" border="1px">

       



        <tr align="center">
        
            <td style="width: 400px;  border:3px solid #C8E183; border-radius: 10px;">
         
                <br>
                <h2 style="font-size:30px;">나의 정보</h2>
                <br><br>
                
                
               <form action="update.yj" method="post">
                <table>
                    <input type="hidden"  name="memId" value="<%= memId %>">
        		
                    <tr>
                        <td>닉네임 </td>
                        <td><input type="text"  name="memNickName" value="<%=memNickName %>"  ></td>
                        
                    </tr>
            
                    <tr>
                        <td>전화번호 </td>
                        <td><input type="text"  name="phone" value="<%= phone %>" ></td>
                    
                    </tr>
        
                    <tr>
                        <td>생년월일  </td>
                        <td><input type="text"  name="birthDate" value="<%= birthDate %>" ></td>
                
                    </tr>
        
                    <tr>
                        <td>이메일 </td>
                        <td><input type="text"  name="email" value="<%= email %>" ></td>
                    
                    </tr>
                    
                    
                    <tr>
                    <td>거주지</td>
                    <td>
                        <select name="residence" id="residence" >
                            <option value="서울" selected>서울</option>
                            <option value="인천">인천</option>
                            <option value="경기">경기</option>
                            <option value="강원">강원</option>
                            <option value="충청">충청</option>
                            <option value="전라">전라</option>
                            <option value="경상">경상</option>
                            <option value="제주">제주</option>
                        </select>

                    </td>
                    
                </tr>
                    
                    
                </table>
                
                
                <div class="btns" align="center">
                <button id="btn" type="submit">수정하기</button>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
                
                </div>
                <br>
                
                

                
                
            </td>
            
            
            </form>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               

            </td>
          
            <td style="width: 400px;  border:3px solid #C8E183;">
                
                        <br>
                        <h2 style="font-size:15px;"><%=memNickName %></h2>
                        
                
                        <table style="text-align: center;">
                            
                                <tr>
                            
                                    <td >feedCount</td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>reviewCount</td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>wishCount</td>
                                   
                                </tr>
                            
                                <tr >
                                   <td>피드</td><br>
                                   <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                   <td>리뷰</td>
                                   <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                   <td>찜한식당</td>
                                </tr>
                                
                     
                        </table> 
                        
                        <div style="width: 400px;">
                            <div align="center">
                                <div class="list-area">

                                    
                                   <!--   <.% for(Feed f : feed) { %.> -->
                                        
                                    <div class="thumbnail" align="center" border="1">
                                      
                                        <!-- <img src="<.%= contextPath %>/<.%=f.getFilePath() %>/<.%=f.getChangeName() %.>"> -->
                                      
                                    </div>

                                   <!--  <.% } %> -->
                                 
                                  
        
                                </div>
        
                            </div>
                            


                        </div>
                        
                      
                
                        
                
                        </div>
                        <div>

                            <button id="btn"  onclick="location.href='<%= contextPath %>/FeedGo.ih' ">피드</button>

                            
                            <button id="btn"  onclick="location.href='<%= contextPath %>/review.yj?cpage=1' ">내 리뷰</button>&nbsp;&nbsp;


                            <button id="btn" onclick="location.href='<%= contextPath %>/wish.yj'">찜한식당</button>

        
          
                        </div>
                        
      
                        
                
                    </td>
                
                
                </tr>
    </table>
    
      <!-- 회원탈퇴 버튼 클릭 시 보여질 Modal -->                 
      <div class="modal fade" id="deleteForm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form action="delete.yj" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
                            탈퇴 후 복구가 불가능합니다. <br>
                            정말로 탈퇴 하시겠습니까? <br>
                        </div>
                        <br>
                            <label for="memPwd" class="mr-sm-2">Password : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="memPwd" name="memPwd"> <br>
                            <input type="hidden" name="memId" value="${ loginMem.memId }">
                            
                            
                            
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger">탈퇴하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <br><br><br>
    <div>
     
        <%@ include file= "../common/footer.jsp" %>

    </div>
    
    
       
    
    
    
    <script>
		document.addEventListener('DOMContentLoaded', function() {
		    var residenceValue = "<%=residence %>";
		
		    var residenceSelect = document.getElementById('residence');
		    
		    for (var i = 0; i < residenceSelect.options.length; i++) {
		        if (residenceSelect.options[i].value === residenceValue) {
		            residenceSelect.options[i].selected = true;
		            break;
		        }
		    }
		});
</script>
</body>
</html>