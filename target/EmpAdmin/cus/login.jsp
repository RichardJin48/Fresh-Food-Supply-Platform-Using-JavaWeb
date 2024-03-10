<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <!--引入bootstrap核心样式-->
    <%--    <link rel="stylesheet" href="../static/bootstrap-3.3.7/css/bootstrap.css">--%>
<%--    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">--%>
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

        .form-buttons {
            display: flex;
            justify-content: space-between;
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
                    <el-form ref="loginForm" :model="loginForm" :rules="rules" label-position="top">
                        <h1 class="text-center text-primary">User Login</h1>
                        <el-form-item label="Username" prop="username">
                            <el-input v-model="loginForm.username" placeholder="Please type your username"></el-input>
                        </el-form-item>
                        <el-form-item label="Password" prop="password">
                            <el-input type="password" v-model="loginForm.password"
                                      placeholder="Please type your password"></el-input>
                        </el-form-item>
                        <el-form-item class="form-buttons">
                            <el-button type="primary" @click="submitLogin">Log In</el-button>
                            <el-button type="info" @click="goToRegister" >Register</el-button>
                            <el-button type="warning" @click="dialogFormVisible1=true">Forget Password</el-button>
                            <el-link href="/emp/login.jsp" type="primary">Employer
                                Login
                            </el-link>
                        </el-form-item>
                    </el-form>
                </div>
            </el-col>
        </el-row>
    </el-container>


    <el-dialog title="Forget Password" center :visible.sync="dialogFormVisible1" width="600px">
        <el-form :model="form" ref="form" :rules="rules" label-width="150px" class="forgot-password-form">
            <el-form-item label="Account" prop="account">
                <el-input v-model="form.account" autocomplete="off" placeholder="Please enter your account"></el-input>
            </el-form-item>
            <el-form-item label="Security Question" prop="question">
                <el-select v-model="form.question" placeholder="Choose security question" style="width:400px">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="Security Answer" prop="answer">
                <el-input v-model="form.answer" autocomplete="off"
                          placeholder="Please enter your security answer"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm1">Submit</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>


    <el-dialog title="Forget Password" center :visible.sync="dialogFormVisible2" width="600px">

        <el-form :model="form2" ref="form2" :rules="rules" label-width="150px" class="form-demo">
            <el-form-item label="new password" prop="newPassword">
                <el-input v-model="form2.newPassword" show-password
                          placeholder="Please enter the new password"></el-input>
            </el-form-item>
            <el-form-item label="confirm password" prop="confirmPassword">
                <el-input v-model="form2.confirmPassword" show-password
                          placeholder="Please enter the new password again"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm2">submit</el-button>
            </el-form-item>

        </el-form>
    </el-dialog>

    <el-dialog title="User Registration" center :visible.sync="registerDialogVisible" width="600px">
        <el-form :model="registerForm" ref="registerForm" :rules="registerRules" label-width="150px" class="form-demo">
            <el-form-item label="Username" prop="username">
                <el-input v-model="registerForm.username" placeholder="Please enter your username"></el-input>
            </el-form-item>
            <el-form-item label="Password" prop="password">
                <el-input type="password" v-model="registerForm.password"
                          placeholder="Please enter your password"></el-input>
            </el-form-item>
            <el-form-item label="Confirm Password" prop="confirmPassword">
                <el-input type="password" v-model="registerForm.confirmPassword"
                          placeholder="Please confirm your password"></el-input>
            </el-form-item>
            <el-form-item label="Nickname" prop="nickname">
                <el-input v-model="registerForm.nickname" placeholder="Please enter your nickname"></el-input>
            </el-form-item>
            <el-form-item label="Gender" prop="gender">
                <el-radio-group v-model="registerForm.gender">
                    <el-radio label="Male"></el-radio>
                    <el-radio label="Female"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="Phone Number" prop="phone">
                <el-input v-model="registerForm.phone" placeholder="Please enter your phone number"></el-input>
            </el-form-item>
            <el-form-item label="Delivery Address" prop="deliveryAddress">
                <el-input v-model="registerForm.deliveryAddress"
                          placeholder="Please enter your delivery address"></el-input>
            </el-form-item>
            <el-form-item label="Personal Signature" prop="personalSignature">
                <el-input v-model="registerForm.personalSignature"
                          placeholder="Please enter your personal signature"></el-input>
            </el-form-item>
            <el-form-item label="Security Question" prop="question">
                <el-select v-model="registerForm.question" placeholder="Choose security question" style="width:400px">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="Security answer" prop="answer">
                <el-input v-model="registerForm.answer" placeholder="Please enter your security answer"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitRegister">Register</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</div>

<!-- 引入 Vue.js 和 Element UI 库 -->
<%--<script src="https://unpkg.com/vue@2/dist/vue.js"></script>--%>
<%--<script src="https://unpkg.com/element-ui/lib/index.js"></script>--%>

<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
<script src="../static/axios-local/node_modules/axios/dist/axios.min.js"></script>


<script src="../static/element-ui-local/node_modules/vue/dist/vue.js"></script>
<script src="../static/element-ui-local/node_modules/element-ui/lib/index.js"></script>


<script>

    new Vue({
        el: '#app',
        data: {
            loginForm: {
                username: '',
                password: '',
            },


            dialogFormVisible1: false,
            dialogFormVisible2: false,

            form: {
                account: '',
                question: '',
                answer: ''
            },

            form2: {
                newPassword: '',
                confirmPassword: ''
            },

            registerDialogVisible: false,
            registerForm: {
                username: '',
                password: '',
                confirmPassword: '',
                nickname: '',
                gender: '',
                phone: '',
                deliveryAddress: '',
                personalSignature: '',
                question: '',
                answer: ''
            },

            registerRules: {
                username: [
                    {required: true, message: 'Please enter your username', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: 'Please enter your password', trigger: 'blur'},
                    {min: 8, max: 16, message: 'Password length should be between 8 and 16 characters', trigger: 'blur'},
                    {pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\d]{8,16}$/, message: 'Password needs both lowercase and uppercase letters.', trigger: 'blur'}

                ],
                confirmPassword: [
                    {required: true, message: 'Please confirm your password', trigger: 'blur'}
                ],
                nickname: [
                    {required: true, message: 'Please enter your nickname', trigger: 'blur'},
                    {min: 3, max: 20, message: 'Nickname length should be between 3 and 20 characters', trigger: 'blur'}
                ],
                gender: [
                    {required: true, message: 'Please select your gender', trigger: 'change'}
                ],
                phone: [
                    {required: true, message: 'Please enter your phone number', trigger: 'blur'},
                    {pattern: /^\d{11}$/, message: 'Please enter a valid 11-digit phone number', trigger: 'blur'}
                ],
                deliveryAddress: [
                    {required: true, message: 'Please enter your delivery address', trigger: 'blur'},
                ],
                personalSignature: [
                    {
                        max: 100,
                        message: 'Personal signature length should be no more than 100 characters',
                        trigger: 'blur'
                    }
                ],
                question: [
                    {required: true, message: 'Please enter your security question', trigger: 'blur'},
                ],
                answer: [
                    {required: true, message: 'Please enter your security answer', trigger: 'blur'},
                ]
            },
            // ...


            rules: {
                account: [
                    {required: true, message: 'Account is empty', trigger: 'blur'}
                ],
                question: [
                    {required: true, message: 'Please choose a question', trigger: 'change'}
                ],
                answer: [
                    {required: true, message: 'Please enter the answer', trigger: 'blur'}
                ],
                newPassword: [
                    {required: true, message: 'Please enter password', trigger: 'blur'},
                    {min: 8, max: 16, message: 'Password length should be between 8 and 16 characters', trigger: 'blur'},
                    {pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\d]{8,16}$/, message: 'Password needs both lowercase and uppercase letters.', trigger: 'blur'}
                ],
                confirmPassword: [
                    {required: true, message: 'Please enter password', trigger: 'blur'}
                ],
            },


            options: [{
                value: '1',
                label: 'What is the name of your university?'
            }, {
                value: '2',
                label: 'What year were you born in?'
            },],

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

                axios.post("/cus?opt=login", requestData, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                }).then(res => {
                    if (res.data.status === "success") {
                        location.href = "/cus?opt=main&userName=" + this.loginForm.username;
                    } else if (res.data.status === "username_error") {
                        this.$message.error("The username is entered incorrectly or not registered.");
                    } else if (res.data.status === "password_error") {
                        this.$message.error("The password is wrong!");
                    }
                }).catch(err => {
                    this.$message.error("An error occurred while processing your request.");
                });
            },

            submitForm1() {
                this.$refs.form.validate(valid => {
                    if (valid) {
                        axios.post('/cus?opt=checkAccount' + '&account=' + this.form.account + '&question=' + this.form.question + '&answer=' + this.form.answer)
                            .then(res => {
                                if (res.data != null) {
                                    if (res.data.question === this.form.question && res.data.answer === this.form.answer) {
                                        this.dialogFormVisible1 = false;
                                        this.dialogFormVisible2 = true;
                                    } else {
                                        this.$message.error("Answer is wrong!");
                                    }
                                } else {
                                    this.$message.error("Account isn't exist!");
                                }
                            })
                    } else {
                        return false;
                    }
                });
            },

            submitForm2() {
                this.$refs.form2.validate((valid) => {
                    if (valid) {
                        if (this.form2.confirmPassword == this.form2.newPassword) {
                            axios.post("/cus?opt=changePSD" + "&newPassword=" + this.form2.newPassword + "&name=" + this.form.account)
                                .then((res) => {
                                    if (res.data === "success") {
                                        this.dialogFormVisible2 = false;
                                        this.$message.success('Password has been changed successfully！');
                                    } else if (res.data === "format failed") {
                                        this.$message.error('Password format is wrong! It should be 8-16 digits and contain numbers, lowercase and uppercase letters！');
                                    }
                                })
                        } else {
                            this.$message.error('The password entered twice does not match');
                        }


                    }
                });
            },

            goToRegister() {
                this.registerDialogVisible = true;
            },

            submitRegister() {
                this.$refs.registerForm.validate(valid => {
                    if (valid) {
                        if (this.registerForm.password !== this.registerForm.confirmPassword){
                            this.$message.error("The password entered twice is not the same");
                        }
                        if(this.registerForm.password === this.registerForm.confirmPassword){
                            const requestData = new URLSearchParams();
                            requestData.append('username', this.registerForm.username);
                            requestData.append('password', this.registerForm.password);
                            requestData.append('gender', this.registerForm.gender);
                            requestData.append('password', this.registerForm.confirmPassword);
                            requestData.append('nickname', this.registerForm.nickname);
                            requestData.append('addr', this.registerForm.deliveryAddress);
                            requestData.append('sign', this.registerForm.personalSignature);
                            requestData.append('phone', this.registerForm.phone);
                            requestData.append('ans', this.registerForm.answer);
                            requestData.append('ques', this.registerForm.question);
                            requestData.append('mode', '2');
                            axios.post("/cus?opt=addCus", requestData, {
                                headers: {
                                    'Content-Type': 'application/x-www-form-urlencoded',
                                },
                            }).then(res => {
                                console.log(res)
                                if (res.data === "success") {
                                    this.registerDialogVisible = false;
                                    this.$message.success("Registration succeeded! Please re-enter the username and password to log in.");
                                } else if (res.data === "username_error") {
                                    this.$message.error("The username has been registered!");
                                }
                            }).catch(err => {
                                this.$message.error('An error occurred while processing your request: ' + err);
                            });
                        }

                    }
                })

            }

        }
    });
</script>

</body>
</html>
