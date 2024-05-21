<template>
  <div id="my-club-add-container">
    <button id="close-button" @click="$emit('closeEvent')">x</button>
    <input
      type="text"
      v-model="club.clubName"
      id="club-regist-title"
      class="form-check-input"
      placeholder="클럽 이름을 입력해 주세요."
    />
    <hr />
    <input
      type="text"
      v-model="club.clubDescription"
      id="club-regist-description"
      class="form-check-input"
      placeholder="클럽 설명을 입력해 주세요."
    />
    <button id="update-btn" @click="registClub">등록</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useMypageStore } from "@/stores/mypage.js";

const store = useMypageStore();

const props = defineProps({
  loginUser: Object,
});

const club = ref({
  clubName: null,
  userId: props.loginUser.userId,
  clubDescription: null,
});

const registClub = function () {
  if (
    club.value.clubName !== null &&
    club.value.clubName.length != 0 &&
    club.value.clubDescription !== null &&
    club.value.clubDescription.length != 0
  ) {
    store.registClub(club.value);
  } else {
    alert("클럽 이름/설명을 입력해 주세요.");
  }
};
</script>

<style scoped>
#my-club-add-container {
  width: 400px;
  height: 400px;
  display: flex;
  flex-direction: column;
  position: fixed;
  top: 50vh;
  left: 50vw;
  transform: translate(-50%, -50%);
  background-color: white;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 0.5px 2px 1px #cbcac8;
  border-radius: 5px;
  padding: 5px 10px 1% 1%;
}

#close-button {
  font-size: 20px;
  background-color: transparent;
  border-style: none;
  color: rgb(139, 137, 137);
  margin-left: 90%;
}

#content {
  display: flex;
  flex-direction: row;
  align-items: center;
  color: rgb(71, 69, 69);
}

#move-button {
  width: 100px;
  min-width: 100px;
  height: 30px;
  min-height: 30px;
  border-style: none;
  border-radius: 5px;
  margin-bottom: 10px;
  background-color: #ffdc5cc3;
  color: rgb(71, 69, 69);
  font-size: 14px;
}

input {
  width: 100%;
  border-style: solid;
  border-width: 1px;
  border-color: rgb(230, 224, 224);
  border-radius: 20px;
  color: rgb(71, 69, 69);
  padding: 2% 3%;
}

#club-regist-title {
  height: 10%;
}

#club-regist-description {
  height: 60%;
}

#update-btn {
  font-size: 15px;
  color: rgb(255, 255, 255);
  border-style: none;
  border-radius: 20px;
  width: 50px;
  height: 25px;
  background-color: rgb(131, 138, 231);
  margin-top: 10px;
}
</style>
