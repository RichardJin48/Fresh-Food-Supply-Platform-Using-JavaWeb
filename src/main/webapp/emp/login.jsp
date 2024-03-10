<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff Login</title>
    <link rel="stylesheet" href="../static/element-ui-local/node_modules/element-ui/lib/theme-chalk/index.css">
    <style>
        body {
            background-color: #f0f2f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            padding: 0;
        }

        .main-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h3.text-primary {
            margin-bottom: 20px;
        }

        h1.text-primary {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div id="app">
    <el-container>
        <el-row>
            <el-col :span="24">
                <div class="main-container">
                    <h3 class="text-primary text-center">Community Fresh Food Supply Platform</h3>
                    <h1 class="text-center text-primary">Staff Login</h1>
                    <el-form action="/emp?opt=login" method="post" label-position="top">
                        <el-form-item label="ID">
                            <el-input v-model="loginForm.username" placeholder="Please type your ID"></el-input>
                        </el-form-item>
                        <el-form-item label="Password">
                            <el-input type="password" v-model="loginForm.password"
                                      placeholder="Please type your password"></el-input>


                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="submitLogin">Log In</el-button>
                            <el-link href="/cus/login.jsp" type="primary" style="margin-left: 200px;">Customer
                                Login
                            </el-link>
                        </el-form-item>
                    </el-form>
                </div>
            </el-col>
        </el-row>
    </el-container>
</div>

<%--<script src="https://unpkg.com/vue@2/dist/vue.js"></script>--%>
<%--<script src="https://unpkg.com/element-ui/lib/index.js"></script>--%>
<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
<script src="../static/axios-local/node_modules/axios/dist/axios.min.js"></script>
<script src="../static/element-ui-local/node_modules/vue/dist/vue.js"></script>
<script src="../static/element-ui-local/node_modules/element-ui/lib/index.js"></script>

<script>
    new Vue({
        el: '#app',
        data() {
            return {
                loginForm: {
                    username: '',
                    password: ''
                }
            };
        },
        methods: {
            submitLogin() {
                const requestData = new URLSearchParams();
                requestData.append('username', this.loginForm.username);
                requestData.append('password', this.loginForm.password);

                if (!this.loginForm.username || !this.loginForm.password) {
                    this.$message.error("Username or password cannot be empty.");
                    return;
                }

                axios.post("/emp?opt=login", requestData, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                }).then(res => {
                    if (res.data.status === "success") {
                        location.href = "/product?opt=list&userCard=" + this.loginForm.username;
                    } else if (res.data.status === "username_error") {
                        this.$message.error("The username is entered incorrectly or not registered.");
                    } else if (res.data.status === "password_error") {
                        this.$message.error("The password is wrong!");
                    }
                }).catch(err => {
                    this.$message.error("An error occurred while processing your request.");
                });
            },

        }

    });
</script>
</body>
</html>
