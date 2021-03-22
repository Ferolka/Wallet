// vue.config.js
module.exports = {
    // proxy all webpack dev-server requests starting with /api
    // to our Spring Boot backend (localhost:8098) using http-proxy-middleware
    // see https://cli.vuejs.org/config/#devserver-proxy
//    publicPath: process.env.NODE_ENV === 'production'
//        ? '/my-project/'
//        : '/',
    devServer: {
       proxy: 'https://online-wallet-01.herokuapp.com'
    },
    // Change build paths to make them Maven compatible
    // see https://cli.vuejs.org/config/
//    outputDir: 'target/dist',
//    assetsDir: 'static'
}