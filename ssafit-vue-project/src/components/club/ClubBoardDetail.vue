<template>
  <div id="club-board-detail-container">
    <div id="board-detail">
      <div id="title" v-if="store.clubBoard.title != ''">
        {{ store.clubBoard.title }}
      </div>
      <hr v-if="store.clubBoard.title == ''" />
      <div id="middle-content">
        <button v-if="store.loginUser.isManager" @click="update">수정</button>
        <div id="btn-space" v-else></div>
        <div id="board-created">{{ sliceDate(store.clubBoard.createdAt) }}</div>
      </div>
      <div id="board-content">
        <div id="content">{{ store.clubBoard.content }}</div>
      </div>
    </div>
    <ClubBoardUpdate v-if="store.updateIsActive" :clubId="props.clubId" @close-event="close" />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useClubStore } from "@/stores/club.js";
import ClubBoardUpdate from "./ClubBoardUpdate.vue";

const store = useClubStore();

const props = defineProps({
  clubId: Number,
});

onMounted(() => {
  store.getClubBoard(props.clubId);
});

const sliceDate = function (date) {
  if (date != null) {
    return date.toString().slice(0, 10);
  }
};

const update = function () {
  store.update();
};

const close = function () {
  store.updateIsActive = false;
};
</script>

<style scoped>
#board-detail {
  height: 50vh;
  display: flex;
  flex-direction: column;
  padding: 3%;
}

#board-detail>* {
  margin: 2% 0;
}

#title {
  font-size: 22px;
  border-width: 900;
  color: rgb(97, 95, 95);
}

hr {
  width: 100%;
}

#middle-content {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

button {
  font-size: 15px;
  color: rgb(255, 255, 255);
  border-style: none;
  border-radius: 20px;
  width: 50px;
  height: 25px;
  background-color: rgb(131, 138, 231);
}

#btn-space {
  width: 50px;
  height: 25px;
}

#board-created {
  color: rgb(97, 95, 95);
}

#board-content {
  height: 60%;
  border-style: dashed;
  border-color: rgb(230, 224, 224);
  border-radius: 20px;
  display: flex;
  flex-direction: row;
  align-items: center;
  word-wrap: break-word;
  word-break: break-all;
  box-sizing: border-box;
  white-space: pre-wrap;
}

#content {
  margin: auto;
  font-size: 16px;
  color: rgb(97, 95, 95);
}
</style>
