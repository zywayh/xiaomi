package xiaomi

import groovy.json.JsonBuilder

class AiController {

//    static responseFormats = ['json']

    def index() {

        println ("params:" + params)

        try {
            println (request.JSON)
            def d = [
                request:[
                        event_property:[:],
                        type:0,
                        locale:"zh-CN",
                        request_id:"5064037ee9964fc4812ce0ded949772a",
                        intent:[
                                score:0.800000011920929,
                                skillType:"Custom",
                                request_type:"Start",
                                query:"打开朱窝",
                                domain:"openplatform",
                                confidence:1,
                                sub_domain:1005230,
                                is_direct_wakeup:false,
                                complete:true,
                                app_id:291309754003751936,
                                need_fetch_token:false
                        ],
                        timestamp:1521100053458
                    ],
                session:[
                    application:[
                        app_id:291309754003751936
                    ],
                    is_new:false,
                    session_id:"291309754003751936_a5a8fd61-e8c7-4425-bc58-a6b0f8a34b1b",
                    user:[
                        access_token:"",
                        user_id:"rplXtvcvirnpbI0ed6TTaA=="
                    ]
                ],
                query:"打开朱窝",
                context:[
                    device_id:"OWLXq19m5LBJhaY9JrLFIQ=="
                ],
                version:0.1
            ]

        } catch(Exception e) {}


        def root = [
                version:"1.0",
                session:[
                        attributes:"attributes"
                ],
                is_session_end:false,
                response:[
                        open_mic:true,         //指示客户端是否需要关闭mic, true，打开麦克风；false，关闭麦克风
                        to_speak:[              //和directive 二选一，复杂的用directive，简单的用tospeak
                                type:0,
                                text:"即将播放海浪的声音"
                        ],
                        to_display:[
                                type:0,            // 0: TTS, 1: Audio, 2: ssml
                                text:"即将播放海浪的声音",
                                ui_template:[
                                        type:0
                                ],
                                widget:[
                                        info:[]
                                ]
                        ],
                        directives:[                //例如播放音频, 和tospeak 二选一，复杂的用directive，简单的用tospeak
                                [
                                        type:"audio",          // audio, tts
                                        audio_item:[
                                                stream:[
                                                        url:"http://zyw-video.oss-cn-beijing.aliyuncs.com/6-3%E5%BE%90%E9%9D%99%E8%95%BE.mp3"
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

        response.outputStream << new JsonBuilder(root).toString().getBytes("utf-8")
//        response.outputStream.write(new JsonBuilder(root).toString().getBytes("utf-8"))

//        respond root
    }
}
