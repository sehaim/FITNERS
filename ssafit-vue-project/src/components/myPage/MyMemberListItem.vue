<template>
  <div id="my-member-item-container" v-if="clubId == myMember.clubId">
    <div id="member">{{ myMember.userId }}</div>
    <div id="btn">
      <button id="regist">수락</button>
      <button id="deny">거절</button>
    </div>
  </div>
</template>

<script setup>
import { useMypageStore } from "@/stores/mypage.js";

const store = useMypageStore();

defineProps({
  clubId: Number,
  myMember: Object,
});
</script>

<style scoped>
#my-member-item-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 70%;
  min-width: 300px;
  max-width: 350px;
  height: 40px;
  padding: 0 5%;
  background-color: rgba(199, 199, 199, 0.384);
  border-radius: 10px;
  margin: 7px 0;
  justify-content: space-between;
}

#btn {
  display: flex;
  flex-direction: row;
  width: 33%;
  justify-content: space-between;
}

button {
  border-style: none;
  border-radius: 10px;
  width: 38px;
  font-size: 14px;
}

#regist {
  background-color: rgb(131, 138, 231);
  color: white;
}

#deny {
  background-color: rgb(231, 134, 131);
  color: white;
}
</style>
