
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'



const app = createApp(App)

app.use(createPinia())
app.use(router)

// 마운트 시점 변경 (라우터의 초기 탐색 후)
router.isReady().then(
    ()=> {
        app.mount('#app')
    }

)

// 1. 마운트 시점 변경  : Vue 라우터가 초기 작업을 완료한 시점으로 변경한다. 우리가 후에 구현할 라우터 기능이 중복 호출이 되지 않기 위해 셋팅
// 2. 마운트 : Vue 어플리케잉션의 인스턴스(app)를 아이디가 app인 요소에 마운트(연결)한다. 아이디가 app인 요소는 프로젝트 생성 시
//            기본으로 만들어지는 frontend/index.html 에 있다.