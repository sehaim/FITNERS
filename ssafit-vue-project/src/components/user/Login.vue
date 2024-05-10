<template>
  <div id="container">
    <div id="field-name">로그인</div>
    <div id="login-form">
      <div id="login-input">
        <label for="id">아이디</label>
        <input type="text" id="id" v-model="user.id" required />
      </div>
      <div id="login-input">
        <label for="password">비밀번호</label>
        <input type="text" id="password" v-model="user.password" required />
      </div>
    </div>
    <button id="login-btn" @click="login">로그인</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();

const user = ref({
  id: "",
  password: "",
});

const login = function () {
  store.login(user.value);
};
</script>

<style scoped>
#container {
  width: 400px;
  height: 450px;
  background-color: rgba(152, 194, 211, 0.63);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: auto;
}

#field-name {
  font-size: 30px;
}

#login-form {
  height: 120px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

#login-input {
  width: 300px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-size: 18px;
}

input {
  height: 35px;
}

#login-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 18px;
}
</style>
