    <template>
      <div class="login-container">
        <div class="submit-form" >
          <a style="font-size: 20px">数字大小写转化程序</a>
      <a-input v-model:value="value" placeholder="请输入需要转化的数字" style="margin-top: 50px"/>
        <a-button @click="submit" style="margin-top: 20px" type="primary">提交</a-button>
          <p  style="margin-top: 20px">{{result}}</p>
      </div>
      </div>
    </template>
<script lang="ts">
import {defineComponent, ref} from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import { Button } from 'ant-design-vue';
import  axios from 'axios'

export default defineComponent({
  name: 'HomeView',
  components: {

  },
  setup() {
    const value = ref<string>('');
    const result = ref();
    const submit = (params: any) => {
      axios.post(process.env.VUE_APP_SERVER+"/App/get",value.value).then((response) => {
        result.value=response
      //  console.log(response)

      })
      console.log(value.value)

    };

    return {
      value,
      result,
      submit
    };
  },
});





</script>
    <style scoped>
    .login-container {
      position: absolute;
      width: 100%;
      height: 100%;


    }
    .submit-form {
      width: 500px;
      margin: 150px auto;
      border-radius: 20px;
    }
    .title-zc {
      text-align: center;
    }
    </style>
