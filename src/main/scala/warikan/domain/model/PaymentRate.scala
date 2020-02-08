package warikan.domain.model

case class PaymentRate(high: Double, middle: Double, low: Double) {
  def rate(paymentType: PaymentType): Double = {
    paymentType match {
      case PaymentType.HIGH => high
      case PaymentType.MIDDLE => middle
      case PaymentType.LOW => low
    }
  }
}
