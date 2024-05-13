<template>
  <div id="container">
    <div id="field-name">
      <div>로그인</div>
      <hr />
    </div>
    <div id="login-form">
      <div id="login-input">
        <label for="userId">아이디</label>
        <input
          type="text"
          class="form-check-input"
          id="userId"
          v-model="user.userId"
          required
        />
      </div>
      <div id="login-input">
        <label for="userPassword">비밀번호</label>
        <input
          type="password"
          class="form-check-input"
          id="userPassword"
          v-model="user.userPassword"
          required
        />
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
  userId: "",
  userPassword: "",
});

const login = function () {
  store.login(user.value);
};
</script>

<style scoped>
#container {
  width: 400px;
  height: 500px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding-top: 20px;
  padding-bottom: 20px;
  margin: auto;
}

#field-name {
  font-size: 25px;
  text-align: center;
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
  font-size: 15px;
}

.form-check-input {
  height: 35px;
  width: 200px;
  border-radius: 5px;
}

#login-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 16px;
  border-radius: 5px;
  background-color: #ffdb5c;
}

hr {
  width: 300px;
}
</style>
