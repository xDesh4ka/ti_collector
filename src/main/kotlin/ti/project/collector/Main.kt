package ti.project.collector

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {
    companion object {
        const val VERSION = "1.0"
        const val SERVICE_NAME = "Collector"
        const val NAME = "Threat Intelligence Collector"

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}