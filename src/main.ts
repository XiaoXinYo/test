import express from 'express';
import { createProxyMiddleware } from 'http-proxy-middleware';
import { ExceptionResponse, ExceptionResponseCode, Reponse } from './core';
import config from './config';

const APP = express();

APP.use((error, request, response, next) => {
    if (error instanceof ExceptionResponse) {
        return response.json(Reponse.error(error.code, error.message));
    }

    return response.status(500).json(Reponse.error(500, "未知错误"));
});

APP.use((request, response, next) => {
    let proxy = config.find(config => request.hostname.includes(config.domain));
    if (!proxy) {
        return createProxyMiddleware({
            target: proxy.url,
            changeOrigin: true,
        })(request, response, next);
    } else {
        throw new ExceptionResponse(ExceptionResponseCode.SYSTEM, '代理不存在')
    }
})

APP.listen(370);