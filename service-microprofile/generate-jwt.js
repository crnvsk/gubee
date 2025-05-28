const jwt = require('jsonwebtoken');
const payload = {
  sub: "usuario1",
  iss: "gubee",
  groups: ["user"],
  exp: Math.floor(Date.now() / 1000) + (60 * 60) // 1 hora
};
const secret = "segredo123";
const token = jwt.sign(payload, secret, { algorithm: 'HS256' });
console.log(token);