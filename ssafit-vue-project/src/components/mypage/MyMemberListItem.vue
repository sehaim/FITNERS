<template>
  <div
    class="item"
    id="my-member-item-container"
    v-if="clubId == myMember.clubId"
  >
    <div id="member">{{ myMember.userName }}</div>
    <div id="btn">
      <button id="regist" @click="registMember">수락</button>
      <button id="decline" @click="declineMember">거절</button>
    </div>
  </div>
</template>

<script setup>
import { useMypageStore } from "@/stores/mypage.js";

const store = useMypageStore();

const props = defineProps({
  clubId: Number,
  myMember: Object,
});

const registMember = function () {
  store.registMember(props.myMember.userId, props.clubId);
};

const declineMember = function () {
  store.declineMember(props.myMember.userId, props.clubId);
};
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

#decline {
  background-color: rgb(231, 134, 131);
  color: white;
}
</style>
