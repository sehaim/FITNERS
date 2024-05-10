<template>
  <div>
    <header>
      <nav id="container">
        <div id="page-nav">
          <RouterLink to="/">logo</RouterLink>
          <RouterLink to="/board">자유게시판</RouterLink>
          <RouterLink to="/club">전체 클럽 목록</RouterLink>
          <RouterLink to="/mypage">MyPage</RouterLink>
        </div>
        <div id="user-nav" v-if="!userId">
          <RouterLink to="/login">로그인</RouterLink>
          <RouterLink to="/signup">회원가입</RouterLink>
        </div>
        <div id="user-nav" v-else>
          <img
            src="@/assets/icon/user-icon.png"
            alt="user-icon"
            id="user-icon"
          />
          <RouterLink to="/home"
            ><img src="@/assets/icon/logout-icon.png" alt="" id="logout-icon"
          /></RouterLink>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { ref } from "vue";

const userId = ref(sessionStorage.getItem("userId"));
const userName = ref(sessionStorage.getItem("userName"));
</script>

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

#page-nav,
#user-nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

#page-nav > * {
  margin-right: 50px;
}

#user-nav > * {
  margin-right: 50px;
}

#user-icon,
#logout-icon {
  width: 60px;
  height: 60px;
  color: white;
}
</style>
