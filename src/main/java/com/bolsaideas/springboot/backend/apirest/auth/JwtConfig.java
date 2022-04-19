package com.bolsaideas.springboot.backend.apirest.auth;

/*seguridad[6]*/
public class JwtConfig {
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAw1rSaP9faYJe1BKxbymsBMq8GIrepEOyvc9DBfnR0vGr6sFE\n" +
            "QUiitCKoVRq8vr4FmQ0pLk61Ask9KAglC0sSojiyvmfN6DT+izawnqithsQmZA+V\n" +
            "7+HbWmd5UniwA570UVt1wqRxo1rbOYKmY7JN3SVjzpPMEtMVxHjg+N20e5CJszqK\n" +
            "kiQN5hlMQsODXilZOLoIItN2dqOsB1+OPC1+1ONQPzk/5fiQL7GZG/ZsywmNhAvB\n" +
            "EOhlsoX60/gAArX9/rl5nC9NX8DKkLyba5CuCI3YOXnN6XBwoUx7qiSLBR47vbLh\n" +
            "/mhYBspjLiv+qGy/xp1uVHhX4RSAOWeJLXNVmQIDAQABAoIBAGsIYM4cVOdXAaPK\n" +
            "FiMkvtXlSgdcVr3DRbRPUZZ9mKOtu5aki0QFiveNIZN3UcBkFmcT2eNARlafcX10\n" +
            "cO9uE2iEDhLahutZ1bjqnvxeyKxU3f/mtiy3H1q55LP14eIp/gxxQuUA+i4ZQpGQ\n" +
            "7p8i+xxWNwfg3GfX9U4vOHvB5PfpdEsQ1AhK9JDa75CGSfYXfhQPJ9M4t3RZZG46\n" +
            "ggyi+XnRNFo5Vn4Q5QvISz/pGu87ZWVt+733x8REezZ7a+SRj4UopvtFXvQduKTv\n" +
            "tLkbKfLndWxnTNoQEIGlYFUqgC1zkb1OIdUFhga9Lx32cMv9nqrvMsr7Hef78yv1\n" +
            "L1Zu4oECgYEA81XY54XWMQdmoeJmLLresW+k4EJjvkSq8hTENDb9V4VR90opHww2\n" +
            "XfsWeKXc4FgqZYSyAlQpvPoFkX8nW6KN9EWJZjQhaModnH1mNu5BJbmQy/3QHyG6\n" +
            "hl4JKFMOdZe5E5jd46LWxrvDc0zF8zTXVYgHtUzVrkdu1mBykqIb0+kCgYEAzYWw\n" +
            "3d2mCrMrJs4INVjtagox6PS3TzZg9FsBRf4NIBji9T9tG0W/LfVmd8Z0ReKnOkza\n" +
            "XEzben/n194nWxsC0GdrAesUB6MOuTfGJKkAUNyZcihkx/kpX65Xm/UrpehWqxJJ\n" +
            "/Pk1BM+bN88qGB/uDxNCeSQN6a3+7mJiFeVD1jECgYEA5g/CVZM6IXzH0kKFK8E6\n" +
            "DzRpBAaA20F9BggQQPXErNzF1DHvkwUu2cgtRMA8hneVDgpZas478AnK/fbkNUUJ\n" +
            "RWwBLfoXpEWDnZMJ8uFsAsjhV5yPCwAOpD+AFPoB77gVKawcDb7FpXucnQR3GyxY\n" +
            "cut7rjQIyw+KgXEKogxWlxECgYAQpU9Z6OXV4AUSs4U+rOEtwX2hXJCsPb9Ei0pj\n" +
            "HNx7SQi4zFZN6yw80K9n7A7myiC5PBhDeYYdOdbRSRDu9BUaRAYKtbt9kttSbQ4D\n" +
            "UhzQb82NzW+8MpYDRd+aphTO7y511Jlhf92nchkkQAcsxQlG90xe+2iVEJ6hOB6x\n" +
            "n0wLQQKBgCisXtEiuzGePdeVCmBfrSCXQo5Yxs/aXfr/aWJleA5fjpOl/olKyEcx\n" +
            "aQNZGGdt4MMxK/l1GFJ4xOhUugziq8V3kcLW352gunGxD5JgspScuelUhG+Lysts\n" +
            "wV6r1Y1PMelzaKAfFOhCFm72AFEeCErdFmFKbxiTGA+AUSnmVejY\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw1rSaP9faYJe1BKxbyms\n" +
            "BMq8GIrepEOyvc9DBfnR0vGr6sFEQUiitCKoVRq8vr4FmQ0pLk61Ask9KAglC0sS\n" +
            "ojiyvmfN6DT+izawnqithsQmZA+V7+HbWmd5UniwA570UVt1wqRxo1rbOYKmY7JN\n" +
            "3SVjzpPMEtMVxHjg+N20e5CJszqKkiQN5hlMQsODXilZOLoIItN2dqOsB1+OPC1+\n" +
            "1ONQPzk/5fiQL7GZG/ZsywmNhAvBEOhlsoX60/gAArX9/rl5nC9NX8DKkLyba5Cu\n" +
            "CI3YOXnN6XBwoUx7qiSLBR47vbLh/mhYBspjLiv+qGy/xp1uVHhX4RSAOWeJLXNV\n" +
            "mQIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
