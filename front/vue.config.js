module.exports = {
  lintOnSave: false,
  publicPath: '/',
  outputDir: '../server/dist/public',
  assetsDir: process.env.NODE_ENV === 'production' ? '../static' : '',
  productionSourceMap: false
};
