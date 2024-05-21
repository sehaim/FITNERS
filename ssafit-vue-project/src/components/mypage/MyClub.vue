<template>
  <div id="my-club-container">
    <div id="my-club-container-header">
      <div id="title">
        <img src="@/assets/img/myclub-icon.png" alt="myclub-icon" />
        <div>My Club</div>
      </div>
      <div>
        <button @click="addClub" v-if="loginUser.isManager">+</button>
        <MyClubAdd
          v-if="store.addClubIsActive"
          @close-event="close"
          :loginUser="loginUser"
        />
      </div>
    </div>
    <hr />
    <MyClubList :loginUser="loginUser" />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useMypageStore } from "@/stores/mypage.js";
import MyClubList from "@/components/mypage/MyClubList.vue";
import MyClubAdd from "@/components/mypage/MyClubAdd.vue";

const store = useMypageStore();

defineProps({
  loginUser: Object,
});

onMounted(() => {
  store.addClubIsActive = false;
});

const addClub = function () {
  store.addClub();
};

const close = function () {
  store.addClubIsActive = false;
};
</script>

<style scoped>
#my-club-container {
  height: 100%;
  min-height: 100%;
  width: 50%;
  min-width: 50%;
  padding: 20px;
  display: flex;
  flex-direction: column;
  z-index: 100;
}

#my-club-container-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 15px;
}

#title {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 22px;
}

img {
  width: 40px;
  margin-right: 20px;
  opacity: 80%;
}

hr {
  width: 90%;
}

button {
  width: 60px;
  border-style: none;
  font-size: 20px;
  border-radius: 10px;
  background-color: #ffdc5cc3;
  color: white;
  margin-right: 10px;
}

hr {
  z-index: -100;
}
</style>
