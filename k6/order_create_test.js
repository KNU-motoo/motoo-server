import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 10, // 동시 사용자 수
    duration: '30s', // 테스트 시간
};

export default function () {
    const payload = JSON.stringify({
        memberId: 1,
        symbol: 'BTC',
        orderType: 'LIMIT',
        orderSide: 'BUY',
        quantity: 1.0,
        price: 50000
    });

    const headers = { 'Content-Type': 'application/json' };

    const res = http.post('http://localhost:8080/orders', payload, { headers });

    check(res, {
        'status is 200': (r) => r.status === 200,
    });

    sleep(1); // 1초 쉬기
}