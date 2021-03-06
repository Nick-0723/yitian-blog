module.exports = {
    devServer: {
        port: 8888,
        proxy: {
            '/proxyApi': {
                target: 'http://localhost:8088',
                changeOrigin: true,
                pathRewrite: {
                    '/proxyApi': ''
                }
            }
        }
    },
    pluginOptions: {
        i18n: {
            locale: 'zh',
            fallbackLocale: 'zh',
            localeDir: 'locales',
            enableInSFC: true
        }
    }
}
