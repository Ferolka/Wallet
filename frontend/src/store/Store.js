import Vue from 'vue'
import Vuex, {Store} from "vuex";
import axios from "axios";
import {CurrentPage} from "@/models/entities/CurrentPage";
import {LogState} from "@/models/entities/LogPage";

Vue.use(Vuex);


const store = new Store({
    state: {
        status: '',
        token: localStorage.getItem('token') || '',
        user: {},
        currentPage: CurrentPage.OUTCOMES,
        logState: LogState.UPCOMING,
        categories: [{
            name: "test category",
            icon: "fa-university",
            outcome: true
        }]
    },
    getters: {
        isLoggedIn: state => !!state.token,
        authStatus: state => state.status,
        currentPage: state => state.currentPage,
        logState: state => state.logState,
        categories: state => state.categories

    },
    actions: {
        login({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                axios({url: 'http://localhost:8080/auth', data: user, method: 'POST'})
                    .then(resp => {
                        const token = resp.data.token;
                        const user = resp.data.user;
                        localStorage.setItem('token', token);
                        axios.defaults.headers.common['Authorization'] = token;
                        commit('auth_success', token, user);
                        resolve(resp)

                    })
                    .catch(err => {
                        commit('auth_error');
                        localStorage.removeItem('token');
                        reject(err)
                    })
            })
        },
        register({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                axios({url: 'http://localhost:8080/auth', data: user, method: 'POST'})
                    .then(resp => {
                        const token = resp.data.token;
                        const user = resp.data.user;
                        localStorage.setItem('token', token);
                        axios.defaults.headers.common['Authorization'] = token;
                        commit('auth_success', token, user);
                        resolve(resp)
                    })
                    .catch(err => {
                        commit('auth_error', err);
                        localStorage.removeItem('token');
                        reject(err)
                    })
            })
        },
        transaction({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                axios({url: 'http://localhost:8080/main', data: user, method: 'POST'})
                    .then(resp => {
                        const token = resp.data.token;
                        const user = resp.data.user;
                        localStorage.setItem('token', token);
                        axios.defaults.headers.common['Authorization'] = token;
                        commit('auth_success', token, user);
                        resolve(resp)
                    })
                    .catch(err => {
                        commit('auth_error', err);
                        localStorage.removeItem('token');
                        reject(err)
                    })
            })
        },
        changeName({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                axios({url: 'http://localhost:8080/settings', data: user, method: 'POST'})
                    .then(resp => {
                        const token = resp.data.token;
                        const user = resp.data.user;
                        localStorage.setItem('token', token);
                        axios.defaults.headers.common['Authorization'] = token;
                        commit('auth_success', token, user);
                        resolve(resp)
                    })
                    .catch(err => {
                        commit('auth_error', err);
                        localStorage.removeItem('token');
                        reject(err)
                    })
            })
        },
        changePassword({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                axios({url: 'http://localhost:8080/settings', data: user, method: 'POST'})
                    .then(resp => {
                        const token = resp.data.token;
                        const user = resp.data.user;
                        localStorage.setItem('token', token);
                        axios.defaults.headers.common['Authorization'] = token;
                        commit('auth_success', token, user);
                        resolve(resp);
                    })
                    .catch(err => {
                        commit('auth_error', err);
                        localStorage.removeItem('token');
                        reject(err);
                    })
            })
        },
        changeCurrentPage({commit}, currentPage) {
            commit("setCurrentPage", currentPage);
        },
        changeLogState({commit}, newLogState) {
            commit("setLogState", newLogState);
        },
        getCategories({commit}) {
            try {
                axios
                    .get('localhost:8080/category/all')
                    .then(data => {
                        commit('setCategories', data);
                        console.log(data)
                    })

            } catch (err) {
                console.error(err);
            }
        }
    },
    mutations: {
        setCategories(state, data) {
            data.forEach(d => state.categories.push(d))
        },
        setCurrentPage(state, currentPage) {
            state.currentPage = currentPage;
        },
        setLogState(state, newLogState) {
            state.logState = newLogState;
            console.log(state.logState);
        },
        auth_request(state) {
            state.status = 'loading'
        },
        auth_success(state, token, user) {
            state.status = 'success';
            state.token = token;
            state.user = user;
            state.currentPage = CurrentPage.OUTCOMES;
            state.logState = LogState.UPCOMING;
        },
        auth_error(state) {
            state.status = 'error';
        },
        logout(state) {
            state.status = '';
            state.token = '';
            state.currentPage = CurrentPage.AUTH;
            state.logState = LogState.IDLE;
        }

    }
});
export default store;

