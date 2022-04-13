package com.example.maskdetection

import android.graphics.RectF

class Box(val rectF: RectF, val description: String, val label: LABEL)

enum class LABEL {
    Mask,
    No_Mask,
    Covered_Mouth_Chin,
    Covered_Nose_Mouth
}
