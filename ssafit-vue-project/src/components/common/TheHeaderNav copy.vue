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
        <div id="user-nav">
          <RouterLink to="/login" v-if="userId === null">로그인</RouterLink>
          <RouterLink to="/signup" v-if="userId === null">회원가입</RouterLink>
          <i class="bi bi-person-fill"></i>
          <RouterLink to="/home"
            ><i class="bi bi-box-arrow-right"></i
          ></RouterLink>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { computed, ref } from "vue";

const userId = ref(sessionStorage.getItem("userId"));
</script>

<style scoped>
* {
  font-size: 17px;
  color: white;
}

#container {
  height: 80px;
  min-height: 80px;
  background-color: #946c99;
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

.bi {
  font-size: 30px;
  color: white;
}
</style>
