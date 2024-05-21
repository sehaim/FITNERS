<template>
  <div id="club-board-update-container">
    <input type="text" v-model="store.clubBoard.title" id="board-update-title">
    <hr />
    <input type="text" v-model="store.clubBoard.content" id="board-update-content">
    <button id="update-btn" @click="updateClubBoard">등록</button>
  </div>
</template>

<script setup>
import { useClubStore } from "@/stores/club.js";

const store = useClubStore();

const updateClubBoard = function() {
  store.updateClubBoard(props.clubId);
}

const props = defineProps({
  clubId: Number
})
</script>

<style scoped>
#club-board-update-container {
  width: 400px;
  height: 400px;
  display: flex;
  flex-direction: column;
  position: fixed;
  top: 50vw;
  left: 50vw;
  transform: translate(-50%, -90%);
  background-color: white;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 0.5px 2px 1px #cbcac8;
  border-radius: 5px;
  padding: 1%;
}

#close-button {
  font-size: 20px;
  background-color: transparent;
  border-style: none;
  color: rgb(139, 137, 137);
  margin-left: 90%;
}

img {
  width: 25px;
  margin-right: 10px;
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
</style>