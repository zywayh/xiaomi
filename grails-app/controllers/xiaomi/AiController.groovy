package xiaomi

class AiController {

    static responseFormats = ['json']

    def index() {

        println ("params:" + params)

        try {
            println ("json: " + request.JSON)
        } catch(Exception e) {}

        def root = [
                version:"1.0",
                session_attributes:[],     //持久化的内容可以放这
                response:[
                        open_mic:false,         //指示客户端是否需要关闭mic, true，打开麦克风；false，关闭麦克风
                        to_speak:[              //和directive 二选一，复杂的用directive，简单的用tospeak
                                type:0,
                                text:"即将播放海浪的声音"
                        ],
                        to_display:[
                                type:0,            // 0: TTS, 1: Audio, 2: ssml
                                text:"即将播放海浪的声音"
                        ],
                        directives:[                //例如播放音频, 和tospeak 二选一，复杂的用directive，简单的用tospeak
                                [
                                        type:"audio",          // audio, tts
                                        audio_item:[
                                                stream:[
                                                        url:"http://zyw-video.oss-cn-beijing.aliyuncs.com/6-3%E5%BE%90%E9%9D%99%E8%95%BE.mp3",
                                                        offset_in_milliseconds:0
                                                ]
                                        ]
                                ],
                                [
                                        type:"tts",          // audio, tts
                                        tts_item:[
                                                "type": "text",
                                                text:"海浪的声音"
                                        ]
                                ]
                        ],
                        is_session_end:false
                ]
        ]

        respond root
    }
}
