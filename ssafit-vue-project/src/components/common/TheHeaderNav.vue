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
        <div id="user-nav" v-if="store.loginUser.userId === null">
          <RouterLink to="/login">로그인</RouterLink>
          <RouterLink to="/signup">회원가입</RouterLink>
        </div>
        <div id="user-nav" v-else>
          <div>{{ store.loginUser.userName }}님 환영합니다!</div>
          <i class="bi bi-person-fill"></i>
          <button @click="store.logout">
            <i class="bi bi-box-arrow-right"></i>
          </button>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();
</script>

<style scoped>
* {
  font-size: 17px;
  color: black;
}

#container {
  height: 80px;
  min-height: 80px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding-left: 5%;
  padding-right: 5%;
  box-shadow: 0px 0.5px 10px 1px #8d8c8a;
}

#page-nav,
#user-nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

#page-nav > * {
  margin-right: 50px;
}

#user-nav > * {
  margin-right: 50px;
}

.bi {
  font-size: 30px;
  color: #276699;
}

button {
  border: 0;
  background-color: transparent;
}

nav a.router-link-exact-active {
  color: #276699;
  font-weight: 700;
}
</style>
