<template>
  <div>
    <header>
      <nav id="container">
        <div id="pageNav">
          <RouterLink to="/">logo</RouterLink>
          <RouterLink to="/board">자유게시판</RouterLink>
          <RouterLink to="/club">전체 클럽 목록</RouterLink>
          <RouterLink to="/mypage">MyPage</RouterLink>
        </div>
        <div id="userNav">
          <RouterLink to="/login">로그인</RouterLink>
          <RouterLink to="/signup">회원가입</RouterLink>
        </div>
      </nav>
    </header>
  </div>
</template>

<style scoped>
* {
  font-size: 20px;
  color: white;
}

#container {
  height: 130px;
  min-height: 130px;

  background-color: #5b8baf;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-left: 5%;
  padding-right: 5%;
}

#pageNav,
#userNav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

#pageNav > * {
  margin-right: 50px;
}

#userNav > * {
  margin-right: 50px;
}
</style>
