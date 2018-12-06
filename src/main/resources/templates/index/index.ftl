<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
</head>
<body>
<div id="app">
    {{ message.bookname }}
    {{ message.charptername }}
    <br>
    <input v-model.lazy="index" @change="changeIndex">
    <div v-html="message.bookcontent"></div>
    <button v-on:click="plusIndex">next</button>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            index: Number(window.localStorage.getItem("index")) || 1,
            message: '页面加载于 ' + new Date().toLocaleString()
        },
        mounted() {
            axios
                    .get('getbook', {params: {'index': this.index}})
                    .then(response => (this.message = response.data))
        },
        methods:{
            changeIndex: function() {
                axios
                        .get('getbook', {params: {'index': this.index}})
                        .then(response => (this.message = response.data))
                window.localStorage.setItem("index", this.index)
            },
            plusIndex: function() {
                this.index = Number(this.index) + 1
                axios
                        .get('getbook', {params: {'index': this.index}})
                        .then(response => (this.message = response.data))
                window.localStorage.setItem("index", this.index)
            },
        }
    })
</script>

</body>
</html>