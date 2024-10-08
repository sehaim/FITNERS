import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_BOARD_API = `http://localhost:8080/ssafit/board`

export const useBoardStore = defineStore('board', () => {
  const loginUser = ref({})

  const doSearch = ref(false)
  const noSearchResult = ref(false)

  const boardList = ref([])

  const getBoardList = function () {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"))
    axios({
      url: REST_BOARD_API,
      method: "GET",
    })
      .then((response) => {
        boardList.value = response.data
        doSearch.value = false;
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  }

  const board = ref({})

  const getBoard = function (boardId) {
    loginUser.value = JSON.parse(localStorage.getItem("loginUser"))
    axios({
      url: REST_BOARD_API + "/" + `${boardId}`,
      method: 'GET'
    })
      .then((response) => {
        board.value = response.data
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  }

  const createBoard = function (board) {
    axios({
      url: REST_BOARD_API,
      method: 'POST',
      data: board
    })
      .then(() => {
        router.push({ name: 'boardList' })
      })
      .catch((err) => {
        router.push({ name: "notFound" });
      })
  }

  const updateBoard = function (board) {
    axios({
      url: REST_BOARD_API + "/" + `${board.boardId}`,
      method: 'PUT',
      data: board
    })
      .then(() => {
        router.push({ name: 'boardList' })
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  }

  const deleteBoard = function (boardId) {
    axios({
      url: REST_BOARD_API + "/" + `${boardId}`,
      method: 'DELETE'
    })
      .then(() => {
        router.push({ name: 'boardList' })
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  }

  const searchBoardList = function (title) {
    axios({
      url: REST_BOARD_API + "/search/" + `${title}`,
      method: 'GET'
    })
      .then((response) => {
        boardList.value = response.data
        doSearch.value = true;
        if (response.data === "") {
          noSearchResult.value = true;
        } else {
          noSearchResult.value = false;
        }
      })
      .catch(() => {
        router.push({ name: "notFound" });
      });
  }

  return { boardList, getBoardList, board, createBoard, getBoard, updateBoard, deleteBoard, searchBoardList, loginUser, noSearchResult, doSearch }
})
