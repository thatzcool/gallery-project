import {defineStore} from 'pinia'
// 사용자의 계정 상태를 관리하는 상태정보관리 기능

//pinia (피니아) 에서 제공하는 defineStore메서드를 호출하여 스토어를 정의함 , 인수로 입력한 account는 스토어의 고유 아이디 이다.
export const useAccountStore = defineStore("account", {

    state: () => ({
        checked: false,    //checked property는 사용자의 로그인 체크 여부
        loggedIn: false,   //상태(state) 의 사용자의 로그인 여부를 나타내는 프로퍼티
    }),
    actions: {
        setChecked(val) {   //사용자의 로그인 체크 여부 값을 수정하는 메서드
            this.checked = val;
        },
        setLoggedIn(val) {   //사용자의 로그인 여부 값을 수정하는 메서드
            this.loggedIn = val;
        },

    },


})

// 계정 데이터를 다루는 계정 스토어로 활용할 것임