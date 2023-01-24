<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <h1>로그인 페이지</h1>
        <hr />
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="아이디를 입력하세요" required><br />
            <input type="text" name="password" placeholder="비밀번호를 입력하세요" required><br />
            아이디를 기억할까요?<input type="checkbox" name="remember"><br />
            <button type="submit">로그인</button>
        </form>
        <%@ include file="../layout/footer.jsp" %>