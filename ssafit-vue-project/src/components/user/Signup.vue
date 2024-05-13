<template>
  <div id="container">
    <div id="field-name">회원가입</div>
    <div id="signup-form">
      <div id="signup-input">
        <label for="userId">아이디</label>
        <input
          type="text"
          id="userId"
          v-model="user.userId"
          placeholder=" 8~20자 (영문, 숫자)"
        />
      </div>
      <div id="signup-input">
        <label for="userName">이름</label>
        <input
          type="text"
          id="userName"
          v-model="user.userName"
          placeholder=" 실명"
          required
        />
      </div>
      <div id="signup-input">
        <label for="userPassword">비밀번호</label>
        <input
          type="text"
          id="userPassword"
          v-model="user.userPassword"
          placeholder=" 8~20자 (영문, 숫자, 특수문자)"
          required
        />
      </div>
      <!-- <div id="signup-input">
        <label for="passwordCheck">비밀번호 확인</label>
        <input type="text" id="passwordCheck" v-model="user.passwordCheck" required>
      </div> -->
      <div id="signup-input">
        <label for="isManager">회원 유형</label>
        <select name="isManager" id="type" v-model="user.isManager">
          <option :value="false">일반 회원</option>
          <option :value="true">매니저</option>
        </select>
      </div>
    </div>
    <button id="signup-btn" @click="signup">가입</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user.js";

const store = useUserStore();

const user = ref({
  userId: "",
  userName: "",
  userPassword: "",
  isManager: "false",
});

const signup = function () {
  store.signup(user.value);
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

#signup-form {
  height: 250px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

#signup-input {
  width: 300px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-size: 18px;
}

input,
select {
  width: 180px;
  height: 35px;
}

#signup-btn {
  width: 200px;
  height: 40px;
  border-style: none;
  font-size: 18px;
}
</style>
